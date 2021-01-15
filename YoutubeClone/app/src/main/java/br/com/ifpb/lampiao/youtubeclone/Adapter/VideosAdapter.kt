package br.com.ifpb.lampiao.youtubeclone.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.ifpb.lampiao.youtubeclone.Model.Videos
import br.com.ifpb.lampiao.youtubeclone.R
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text


class VideosAdapter(val videos: MutableList<Videos>): RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.lista_videos,parent,false)
        return VideosViewHolder(view)
    }

    override fun getItemCount(): Int = videos.size


    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        holder.bind(videos[position])
    }

    inner class  VideosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(videos: Videos) {
            itemView.findViewById<ImageView>(R.id.thumbnail).setImageResource(videos.thumb)
            itemView.findViewById<CircleImageView>(R.id.foto).setImageResource(videos.foto)
            itemView.findViewById<TextView>(R.id.titulo).setText(videos.titulo)
            itemView.findViewById<TextView>(R.id.tempoVideo).setText(videos.tempoVideo)
            itemView.findViewById<TextView>(R.id.visualizacao).setText(videos.visualizacao)
        }
    }
}

