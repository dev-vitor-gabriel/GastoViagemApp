package com.example.gastoviagemapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastoviagemapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // View(Tela que está sendo vista) Binding(Conexão entre partes, interface e código)
    //ActivityMainBinding foi a classe criada para mapear os elementos
    //o inflate serve para colocar o layout em uso
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

        supportActionBar?.apply {
            title = getString(R.string.app_name)
        }

    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calculate) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString()    != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f)
    }
    private fun calculate(){
        if(isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy

            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
        }else{
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }
    }
}