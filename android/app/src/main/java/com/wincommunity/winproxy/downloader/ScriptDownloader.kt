package com.wincommunity.winproxy.downloader

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.documentfile.provider.DocumentFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.TimeUnit

sealed class DownloadState {
    object Idle : DownloadState()
    data class Downloading(val currentFile: String, val progress: Int) : DownloadState()
    data class Success(val installedPath: String) : DownloadState()
    data class Error(val message: String) : DownloadState()
}

data class ScriptFileSpec(
    val fileName: String,
    val downloadUrl: String
)

class ScriptDownloader(private val context: Context) {

    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private val _downloadState = MutableStateFlow<DownloadState>(DownloadState.Idle)
    val downloadState: StateFlow<DownloadState> = _downloadState

    val filesToDownload = listOf(
        ScriptFileSpec(
            fileName = "! WinProxy Loader.lua",
            downloadUrl = "https://raw.githubusercontent.com/LansGameTry/WinProxyCPS/main/-%20WinProxy%20Loader.lua"
        )
    )

    fun getCandidateDirectories(): List<File> {
        val storageRoot = Environment.getExternalStorageDirectory()
        return listOf(
            File(storageRoot, "Android/media/com.rtsoft.growtopia/scripts"),
            File(storageRoot, "Growtopia/scripts"),
            File(storageRoot, "Bothax/scripts"),
            File(storageRoot, "Download/WinProxy")
        )
    }

    suspend fun installToDirectory(targetDir: File) = withContext(Dispatchers.IO) {
        try {
            if (!targetDir.exists()) {
                targetDir.mkdirs()
            }
            if (!targetDir.canWrite()) {
                throw IllegalAccessException("Write permission denied to: ${targetDir.absolutePath}")
            }

            for ((index, spec) in filesToDownload.withIndex()) {
                _downloadState.value = DownloadState.Downloading(spec.fileName, ((index) * 50))
                val targetFile = File(targetDir, spec.fileName)

                val request = Request.Builder()
                    .url(spec.downloadUrl)
                    .header("User-Agent", "WinProxy-Android-Installer/1.0")
                    .build()

                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) {
                        throw Exception("Failed to download ${spec.fileName}: HTTP ${response.code}")
                    }
                    val body = response.body ?: throw Exception("Empty response from ${spec.fileName}")
                    FileOutputStream(targetFile).use { output ->
                        body.byteStream().copyTo(output)
                    }
                }
            }

            _downloadState.value = DownloadState.Success(targetDir.absolutePath)
        } catch (e: Exception) {
            _downloadState.value = DownloadState.Error(e.localizedMessage ?: "An error occurred during download")
        }
    }

    suspend fun installToSafUri(treeUri: Uri) = withContext(Dispatchers.IO) {
        try {
            val documentDir = DocumentFile.fromTreeUri(context, treeUri)
                ?: throw Exception("Cannot access the selected directory.")

            for ((index, spec) in filesToDownload.withIndex()) {
                _downloadState.value = DownloadState.Downloading(spec.fileName, ((index) * 50))

                val existing = documentDir.findFile(spec.fileName)
                existing?.delete()

                val newFile = documentDir.createFile("application/octet-stream", spec.fileName)
                    ?: throw Exception("Failed to create file ${spec.fileName} in selected folder.")

                val request = Request.Builder()
                    .url(spec.downloadUrl)
                    .header("User-Agent", "WinProxy-Android-Installer/1.0")
                    .build()

                client.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) {
                        throw Exception("Failed to download ${spec.fileName}: HTTP ${response.code}")
                    }
                    val body = response.body ?: throw Exception("Empty response")
                    context.contentResolver.openOutputStream(newFile.uri)?.use { output ->
                        body.byteStream().copyTo(output)
                    } ?: throw Exception("Failed to open output write stream.")
                }
            }

            _downloadState.value = DownloadState.Success(documentDir.name ?: "Selected Folder")
        } catch (e: Exception) {
            _downloadState.value = DownloadState.Error(e.localizedMessage ?: "Failed to install via SAF")
        }
    }

    fun resetState() {
        _downloadState.value = DownloadState.Idle
    }
}
