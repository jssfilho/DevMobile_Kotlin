package br.edu.ifpb.lampiao.lojavirtual.Fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import br.edu.ifpb.lampiao.lojavirtual.Model.Dados
import br.edu.ifpb.lampiao.lojavirtual.R
import com.afollestad.materialdialogs.MaterialDialog
import com.google.android.material.dialog.MaterialDialogs
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_produtos.*
import kotlinx.android.synthetic.main.pagamento.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Produtos.newInstance] factory method to
 * create an instance of this fragment.
 */
class Produtos : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var Adapter: GroupAdapter<ViewHolder>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Adapter = GroupAdapter()
        recycler_produtos.adapter = Adapter
        Adapter.setOnItemClickListener { item, view ->
            val DialogView = LayoutInflater.from(context).inflate(R.layout.pagamento,null)
            val builder = AlertDialog.Builder(context).setView(DialogView).setTitle("Formas de Pagamento")

            val maAlertDialog = builder.show()
            maAlertDialog.bt_pagar.setOnClickListener {
                maAlertDialog.dismiss()
                val pagamento = maAlertDialog.fm_pagamentos.text.toString()
                if(pagamento == "249.99"){
                    //Toast.makeText(context,"Pagamento Concluido",Toast.LENGTH_SHORT).show()
                    MaterialDialog.Builder(this!!.requireContext()).title("Pagamento Concluido").content("Obrigado Pela Compra Volte Sempre").show()
                }else{
                    Toast.makeText(context,"Pagamento Recusado",Toast.LENGTH_SHORT).show()
                }
            }

        }
        BuscarProdutos()
    }
    private inner class ProdutosItem(internal val adProdutos:Dados): Item<ViewHolder>() {
        override fun getLayout(): Int {
            return R.layout.lista_produtos
        }

        override fun bind(viewHolder: ViewHolder, position: Int) {
            viewHolder.itemView.findViewById<TextView>(R.id.nome_produto_lista).text = adProdutos.nome
            viewHolder.itemView.findViewById<TextView>(R.id.preco_produto_lista).text = adProdutos.preco
            Picasso.get().load(adProdutos.uid)
                .into(viewHolder.itemView.findViewById<ImageView>(R.id.foto_produto_lista))
        }
    }
    private fun BuscarProdutos(){
        FirebaseFirestore.getInstance().collection("Produtos")
            .addSnapshotListener { snapshot, exception -> exception?.let {
                return@addSnapshotListener
            }
                snapshot?.let {
                    for (doc in snapshot){
                        val produtos = doc.toObject(Dados::class.java)
                        Adapter.add(ProdutosItem(produtos))
                    }
                }
            }
    }





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_produtos, container, false)
    }
    /*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Produtos.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                Produtos().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
    */
}
