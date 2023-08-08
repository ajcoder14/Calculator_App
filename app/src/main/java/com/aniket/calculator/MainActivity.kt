package com.aniket.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aniket.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //by use binding we don't need to initialize element
        binding.btnAllClear.setOnClickListener{
            binding.txtInput.text = ""
            binding.txtSolution.text = ""
        }

        binding.btnC.setOnClickListener {

            //To reduce no. by one use dropLast method
            binding.txtInput.text = binding.txtInput.text.dropLast(1)
        }

        binding.btnZero.setOnClickListener{
            //append use to add previous button value
            binding.txtInput.append("0")
        }

        binding.btn1.setOnClickListener{
            binding.txtInput.append("1")
        }

        binding.btn2.setOnClickListener{
            binding.txtInput.append("2")
        }

        binding.btn3.setOnClickListener{
            binding.txtInput.append("3")
        }

        binding.btn4.setOnClickListener{
            binding.txtInput.append("4")
        }

        binding.btn5.setOnClickListener{
            binding.txtInput.append("5")
        }

        binding.btn6.setOnClickListener{
            binding.txtInput.append("6")
        }

        binding.btn7.setOnClickListener{
            binding.txtInput.append("7")
        }

        binding.btn8.setOnClickListener{
            binding.txtInput.append("8")
        }

        binding.btn9.setOnClickListener{
            binding.txtInput.append("9")
        }

        binding.btnDecimal.setOnClickListener{
            binding.txtInput.append(".")
        }

        binding.btnPlus.setOnClickListener{
            binding.txtInput.append(" + ")
        }

        binding.btnMinus.setOnClickListener{
            binding.txtInput.append(" - ")
        }

        binding.btnMultiply.setOnClickListener{
            binding.txtInput.append(" * ")
        }

        binding.btnDivide.setOnClickListener {
            binding.txtInput.append(" / ")

        }
        binding.btnOpenBracket.setOnClickListener{
            binding.txtInput.append(" ( ")
        }

        binding.btnCloseBracket.setOnClickListener{
            binding.txtInput.append(" ) ")
        }

        binding.btnEqual.setOnClickListener{

                try {
                    //here we do operations
                    val expression = ExpressionBuilder(binding.txtInput.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()

                    if(result == longResult.toDouble()) {
                        binding.txtSolution.text = longResult.toString()

                    }
                    else {
                        binding.txtSolution.text = result.toString()
                    }
                } catch (e: Exception){
                    binding.txtSolution.text ="Error"

                }
            }
    }

}
