package br.edu.utfpr.calculaimccl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    
    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    private lateinit var tvResult: TextView
    private lateinit var btCalcular: Button
    private lateinit var btLimpar: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        tvResult = findViewById(R.id.tvResultado)
        btCalcular = findViewById(R.id.btCalcular)
        btLimpar = findViewById(R.id.btLimpar)
        
        btCalcular.setOnClickListener { 
            btCalcularOnClick()
        }
        
        btLimpar.setOnClickListener { 
            btLimparOnClick()
        }
        
        btLimpar.setOnLongClickListener {
            Toast.makeText(this, getString(R.string.bot_o_que_limpa), Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener false
        }
    }
    private fun btCalcularOnClick()
    {
        if(etPeso.text.toString().isEmpty()){
            etPeso.error = getString(R.string.campo_deve_ser_preenchido)
            return
        }
        if(etAltura.text.toString().isEmpty()){

            etAltura.error = getString(R.string.campo_deve_ser_preenchido)
            return
        }
        if(etAltura.text.toString() == "0"){
            etAltura.error = getString(R.string.n_o_pode_calcular_dividido_por_zero)
            return
        }
        val peso = etPeso.text.toString().toDouble()
        val alt = etAltura.text.toString().toDouble()
        val resp = peso / Math.pow(alt, 2.0)
        //println(resp)
        tvResult.setText(String.format( "%.2f",resp))
    }


    private fun btLimparOnClick(){
        etPeso.setText("")
        etAltura.setText("")
        tvResult.setText(R.string._0_0)
        etPeso.requestFocus()
    }
    
}