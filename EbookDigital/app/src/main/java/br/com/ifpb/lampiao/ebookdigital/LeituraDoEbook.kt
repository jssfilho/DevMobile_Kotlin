package br.com.ifpb.lampiao.ebookdigital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle

class LeituraDoEbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leitura_do_ebook)

        var pdfview = findViewById<PDFView>(R.id.pdfview)
        pdfview.fromAsset("ebook.pdf")
            .scrollHandle(DefaultScrollHandle(this))//numeração das paginas
            .load()
            /*.enableDoubletap(true)//zoom
            .defaultPage(0)
            .enableSwipe(true)//trocar de pagina

            .swipeHorizontal(false) //leitura horizontal ou não(false)
             */


    }
}