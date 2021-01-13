package br.com.ifpb.lampiao.netflixclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView

class Video : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val video = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-c5188.appspot.com/o/videos%2FTHE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=e26e4af3-2c68-4c60-8934-2a5f7be0748c")
        val decordview = window.decorView
        val opcoes = View.SYSTEM_UI_FLAG_FULLSCREEN
        decordview.systemUiVisibility =opcoes
        var video_view = findViewById<VideoView>(R.id.videoView)
        video_view.setMediaController(MediaController(this))
        video_view.setVideoURI(video)
        video_view.requestFocus()
    }
}