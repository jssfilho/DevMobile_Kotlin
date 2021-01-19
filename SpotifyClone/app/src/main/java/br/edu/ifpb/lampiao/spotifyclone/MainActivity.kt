package br.edu.ifpb.lampiao.spotifyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import br.edu.ifpb.lampiao.spotifyclone.Fragment.Biblioteca
import br.edu.ifpb.lampiao.spotifyclone.Fragment.Buscar
import br.edu.ifpb.lampiao.spotifyclone.Fragment.Home
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var Content: FrameLayout? = null
    private var mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.nav_inicio -> {
                val fragment = Home.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_buscar -> {
                val fragment = Buscar.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_biblioteca -> {
                val fragment = Biblioteca.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Content = findViewById<FrameLayout>(R.id.content_view)
        var bt_menu = findViewById<BottomNavigationView>(R.id.bottom_menu)
        bt_menu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = Home.newInstance()
        addFragment(fragment)


    }
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_view,fragment,fragment.javaClass.simpleName)
            .commit()
    }
}