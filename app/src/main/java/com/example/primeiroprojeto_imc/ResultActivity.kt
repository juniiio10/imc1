package com.example.primeiroprojeto_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result= intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()



                 /*
                 Menor que 18.5 - Abaixo do peso
                 Entre 18.5 e 24.9 - Peso normal
                 Entre 25.0 e 29.9 - Pré-obesidade
                 Entre 30.0 e 34.9 - Obesidade Grau 1
                 Entre 35.0 e 39.9 - Obesidade Grau 2
                 Acima de 40 - Obesidade Grau 3
                 */


        var classificacao = ""

        if (result < 18.5f){
            classificacao = "Abaixo do peso"
        } else if (result >= 18.5f && result < 24.9f){
            classificacao = "Peso normal"
        }else if (result >= 25.0f && result < 29.9f){
            classificacao = "Pré-obesidade"
        } else if (result >= 30.0f && result < 34.9f){
            classificacao = "Obesidade Grau 1"
        }else if (result >= 35.0f && result < 39.9f){
            classificacao = "Obesidade Grau 2"
        }else if (result  >= 40.0f){
            classificacao = "Obesidade Grau 3"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}