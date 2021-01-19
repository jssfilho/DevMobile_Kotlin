package br.edu.ifpb.lampiao.spotifyclone.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifpb.lampiao.spotifyclone.Detalhes
import br.edu.ifpb.lampiao.spotifyclone.Model.*
import br.edu.ifpb.lampiao.spotifyclone.R
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var categoriaAdapter: CategoriaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view : View, savedInstanceState: Bundle?){

        val categorias = arrayListOf<Categoria>()
        categoriaAdapter = CategoriaAdapter(categorias)
        var recycler_view1 = view.findViewById<RecyclerView>(R.id.recycler_view_categorias)
        recycler_view1.adapter = categoriaAdapter
        recycler_view1.layoutManager = LinearLayoutManager(context)
        retrofit().create(SpotifyApi::class.java)
            .listCategorias()
            .enqueue(object : Callback<Categorias>{
                override fun onFailure(call: Call<Categorias>, t: Throwable) {
                    Toast.makeText(context,"Erro no servidor",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Categorias>, response: Response<Categorias>) {
                    if(response.isSuccessful){
                        response.body()?.let {
                            categoriaAdapter.categorias.clear()
                            categoriaAdapter.categorias.addAll(it.categorias)
                            categoriaAdapter.notifyDataSetChanged()
                        }
                    }
                }
            })
    }
    private inner class CategoriaAdapter(internal val categorias: MutableList<Categoria>): RecyclerView.Adapter<CategoriaHolder> (){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaHolder {
           return CategoriaHolder((layoutInflater.inflate(R.layout.categoria_item,parent,false)))
        }

        override fun getItemCount():Int =  categorias.size

        override fun onBindViewHolder(holder: CategoriaHolder, position: Int) {
            val categoria = categorias[position]
            holder.bind(categoria)
        }
    }


    private inner class CategoriaHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(categoria: Categoria){
            itemView.findViewById<TextView>(R.id.text_titulo).text = categoria.titulo
            itemView.findViewById<RecyclerView>(R.id.recycler_albuns).adapter = AlbunsAdapter(categoria.albuns){album ->
                val intent = Intent(context,Detalhes::class.java)
                intent.putExtra("album",album.album)
                intent.putExtra("titulos", titulos[album.id])
                print(titulos[album.id])
                startActivity(intent)
            }
            itemView.findViewById<RecyclerView>(R.id.recycler_albuns).layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        }

    }

    companion object {

        fun newInstance(): Home{
            val fragmentHome = Home()
            val argumentos = Bundle()
            fragmentHome.arguments= argumentos
            return fragmentHome
        }




        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                Home().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }*/
    }


    private inner class AlbunsAdapter(private val albuns: List<Album>,private val listener: ((Album)->Unit)?): RecyclerView.Adapter<AlbunsHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbunsHolder =  AlbunsHolder(
            layoutInflater.inflate(R.layout.album_item,parent,false),listener)


        override fun getItemCount(): Int = albuns.size

        override fun onBindViewHolder(holder: AlbunsHolder, position: Int) {
            val album = albuns[position]
            holder.bind(album)

        }
    }

    private inner class AlbunsHolder(itemView: View,val onClick: ((Album) -> Unit)?): RecyclerView.ViewHolder(itemView){
        fun bind(album: Album){
           Picasso.get().load(album.album).placeholder(R.drawable.placeholder).fit().into(itemView.findViewById<ImageView>(R.id.album_imagem))
           itemView.findViewById<ImageView>(R.id.album_imagem).setOnClickListener {
               onClick?.invoke(album)
           }
        }
    }
}