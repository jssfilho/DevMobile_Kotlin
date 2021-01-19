package br.edu.ifpb.lampiao.spotifyclone.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifpb.lampiao.spotifyclone.Model.Secao
import br.edu.ifpb.lampiao.spotifyclone.Model.dados
import br.edu.ifpb.lampiao.spotifyclone.R
import android.view.LayoutInflater as layoutInflater

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Buscar.newInstance] factory method to
 * create an instance of this fragment.
 */
class Buscar : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var secaoAdapter: SecaoAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: layoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        secaoAdapter = SecaoAdapter((dados()))
        var recycler_secao = view.findViewById<RecyclerView>(R.id.recycler_view_secao)
        recycler_secao.adapter = secaoAdapter
        recycler_secao.layoutManager = GridLayoutManager(context,2)
    }

    private inner class SecaoAdapter(private val secoes: MutableList<Secao>): RecyclerView.Adapter<SecaoHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecaoHolder {
            return SecaoHolder(layoutInflater.inflate(R.layout.secao_item,parent,false))
        }

        override fun getItemCount(): Int = secoes.size

        override fun onBindViewHolder(holder: SecaoHolder, position: Int) {
            val secao : Secao = secoes[position]
            holder.bind(secao)
        }
    }

    private inner class SecaoHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(secao: Secao){
            itemView.findViewById<TextView>(R.id.textSecao).text = secao.nameSecao
            itemView.findViewById<ImageView>(R.id.image_secao).setImageResource(secao.secao)

        }
    }

    companion object {


        fun newInstance(): Buscar{
            val fragmentBuscar = Buscar()
            val argumentos = Bundle()
            fragmentBuscar.arguments = argumentos
            return fragmentBuscar

        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Buscar.

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                Buscar().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }*/
    }
}