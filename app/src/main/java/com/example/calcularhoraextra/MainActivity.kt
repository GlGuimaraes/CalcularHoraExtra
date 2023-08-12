package com.example.calcularhoraextra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.calcularhoraextra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.butttonCalculate.setOnClickListener(this)
        binding.imageHelpTop.setOnClickListener(this)
        binding.imageHelpMid.setOnClickListener(this)
        binding.imageHelpBot.setOnClickListener(this)

    }
    override fun onClick(view: View) {
        if (view.id == R.id.buttton_calculate) {
            calcular()
        }
        if(view.id == R.id.image_helpTop){
            HelpTop()
        }
        if (view.id == R.id.image_helpMid){
         HelpMid()
        }
        if (view.id == R.id.image_helpBot){
            HelpBot()
        }
    }


    private fun valid(): Boolean {
        return (binding.editGrossSalary.text.toString() != ""
                && binding.editWorkload.text.toString() != ""
                && binding.editQuantyHour.text.toString() != "")
    }

    private fun calcular() {
        if (valid()) {
            val salario = binding.editGrossSalary.text.toString().toFloat()
            val cargaHoraria = binding.editWorkload.text.toString().toFloat()
            val quantHora = binding.editQuantyHour.text.toString().toFloat()

            val totalHora = salario / cargaHoraria
            val total = (totalHora + totalHora / 2) * quantHora

            val a = "R$ ${"%.2f".format(total)}"

            binding.textTotalReceivable.text = "Você irá receber:"
            binding.textAmoutReceivable.text = a

        } else {
            Toast.makeText(this, "Preencha todos os campos Corretamente", Toast.LENGTH_SHORT).show()
        }

    }

    fun HelpTop(){
        binding.textImageHelpTop.text = "Salário bruto é aquele registrado na CTPS, sem considerar os descontos legais (INSS e IR)."
    }
    fun HelpMid(){
        binding.textImageHelpMid.text = "Ex: 44h semanais equivalem a 220h mensais)."
    }

    fun HelpBot(){
        binding.textImageHelpBot.text = "Informar a quantidade de Hora Extra que você quer calcular)."
    }
}