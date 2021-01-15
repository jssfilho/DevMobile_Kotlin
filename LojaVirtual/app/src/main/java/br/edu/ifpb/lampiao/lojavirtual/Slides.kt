package br.edu.ifpb.lampiao.lojavirtual


import android.content.Intent
import android.os.Bundle
import br.edu.ifpb.lampiao.lojavirtual.Form.FormLogin
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide

class Slides : IntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_slides)
        isButtonBackVisible = false
        isButtonNextVisible = false
        addSlide (
            SimpleSlide.Builder()
                    .background(R.color.Roxo)
                    .backgroundDark(R.color.white)
                    .image(R.drawable.drawer)
                    .title("Loja Online de Calçados")
                    .description("Entre e confira as promações que preparamos para você")
                    .build()
        )
        addSlide(
            SimpleSlide.Builder()
                    .background(R.color.AzulVerde)
                    .title("Crie uma conta Grátis")
                    .canGoBackward(false)
                    .description("Cadastre-se agora mesmo! E venha conhecer os nossos produtos.")
                    .build()
        )


    }

    override fun onDestroy() {
        super.onDestroy()
        var intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}