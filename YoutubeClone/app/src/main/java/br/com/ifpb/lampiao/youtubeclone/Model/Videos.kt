package br.com.ifpb.lampiao.youtubeclone.Model

data class Videos(
    val thumbnail: Int,
    val foto: Int,
    val tempoVideo: String,
    val visualizacao: String

)
class VideosBuilder {
    var thumb: Int =0
    var foto: Int = 0
    var tempoVideo: String = ""
    var titulo: String = ""
    var visualizacao: String = ""

    fun build(): Videos = Videos(thumb,foto,tempoVideo,titulo,visualizacao)


}

fun videos(block: VideosBuilder.() -> Unit): Videos = VideosBuilder().apply(block).build()

fun addVideos():MutableList<Videos> = mutableListOf(
    videos  {
        thumb = R.drawable.minecrafit
        foto =R.drawable.canal1
        tempoVideo = "25:00"
        titulo = "Minecraft: O Inicio de Gameplay"
        visualizacao = "Minecraft 56 mil visualizações - 8 meses"
    }
)