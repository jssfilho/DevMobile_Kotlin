package br.edu.ifpb.lampiao.spotifyclone.Fragment

import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import br.edu.ifpb.lampiao.spotifyclone.FragmentsTab.Albuns
import br.edu.ifpb.lampiao.spotifyclone.FragmentsTab.Artistas
import br.edu.ifpb.lampiao.spotifyclone.FragmentsTab.Playlists
import br.edu.ifpb.lampiao.spotifyclone.R
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Biblioteca.newInstance] factory method to
 * create an instance of this fragment.
 */
class Biblioteca : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biblioteca, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var adapter = FragmentPagerItemAdapter(fragmentManager, FragmentPagerItems.with(context)
            .add("Playlists",Playlists::class.java)
            .add("Artistas",Artistas::class.java)
            .add("Albuns", Albuns::class.java)
            .create())
        var view_pager = view.findViewById<ViewPager>(R.id.viewpager)
        view_pager.adapter = adapter
        var smartTab = view.findViewById<SmartTabLayout>(R.id.viewpagertab)
        smartTab.setViewPager(view_pager)

    }

    companion object {
        fun newInstance(): Biblioteca{
            val fragmentBiblioteca = Biblioteca()
            val argumentos = Bundle()
            fragmentBiblioteca.arguments = argumentos
            return fragmentBiblioteca

        }
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Biblioteca.

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Biblioteca().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*/
    }

}