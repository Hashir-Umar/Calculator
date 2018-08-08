package com.example.hashir.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var value1: Double =0.0
    var value2: Double = 0.0
    var flag: Boolean? = true
    var opt : Char = ' '

    lateinit var btn1 : Button
    lateinit var btn2 : Button
    lateinit var btn3 : Button
    lateinit var btn4 : Button
    lateinit var btn5 : Button
    lateinit var btn6 : Button
    lateinit var btn7 : Button
    lateinit var btn8 : Button
    lateinit var btn9 : Button
    lateinit var btn0 : Button
    lateinit var btnPoint : Button
    lateinit var btnClear : Button

    lateinit var btnDel : Button
    lateinit var btnEqual : TextView

    lateinit var btnPlus : Button
    lateinit var btnMinus : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivide : Button

    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var text3 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textArea1.setText("")
        textArea2.setText("")
        textArea3.setText("")

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btnPoint = findViewById(R.id.btnPoint)
        btnClear = findViewById(R.id.btnClear)

        btnEqual = findViewById(R.id.btnEqual)
        btnDel = findViewById(R.id.btnDel)

        text1 = findViewById(R.id.textArea1)
        text2 = findViewById(R.id.textArea2)
        text3 = findViewById(R.id.textArea3)

        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn0.setOnClickListener(this)
        btnPoint.setOnClickListener(this)
        btnClear.setOnClickListener(this)

        btnDel.setOnClickListener(this)
        btnEqual.setOnClickListener(this)

        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivide.setOnClickListener(this)

    }

    override fun onClick(obj: View?)
    {

        when (obj?.id) {

            R.id.btn1 -> { text3.append("1") }
            R.id.btn2 -> { text3.append("2") }
            R.id.btn3 -> { text3.append("3") }
            R.id.btn4 -> { text3.append("4") }
            R.id.btn5 -> { text3.append("5") }
            R.id.btn6 -> { text3.append("6") }
            R.id.btn7 -> { text3.append("7") }
            R.id.btn8 -> { text3.append("8") }
            R.id.btn9 -> { text3.append("9") }
            R.id.btn0 -> { text3.append("0") }
            R.id.btnPoint -> {
                var str : String = text3.text.toString()
                var i = str.indexOf(".")
                println(i)
                if(i == -1)
                    text3.append(".")
            }
            R.id.btnClear -> {
                text1.text = ""
                text2.text = ""
                text3.text = ""
                flag = true
            }

            R.id.btnPlus -> {

                if(flag == true&& text3.text.isNotEmpty()){
                    val str: String = text3.getText().toString()
                    value1 = str.toDouble()
                    text1.setText(str)
                    flag = null
                    text3.setText("")
                }
                text2.setText("+")
                opt = '+'
            }
            R.id.btnMinus -> {
                if(flag == true && text3.text.isNotEmpty()){
                    val str: String = text3.getText().toString()
                    value1 = str.toDouble()
                    text1.setText(str)
                    flag = null
                    text3.text = ""
                }
                text2.setText("-")
                opt = '-'
            }
            R.id.btnDivide -> {
                if(flag == true&& text3.text.isNotEmpty()){
                    val str: String = text3.getText().toString()
                    value1 = str.toDouble()
                    text1.setText(str)
                    flag = null
                    text3.text = ""
                }
                text2.setText("/")
                opt = '/'
            }
            R.id.btnMultiply -> {
                if(flag == true && text3.text.isNotEmpty()){
                    val str: String = text3.getText().toString()
                    value1 = str.toDouble()
                    text1.setText(str)
                    flag = null
                    text3.text = ""
                }
                text2.setText("*")
                opt = '*'
            }
            R.id.btnEqual -> {

                val str: String = text3.getText().toString()
                value2 = str.toDouble()

                text1.text = ""
                text2.text = ""

                var ans: Double = 0.0

                if(opt == '+')
                    ans = value1 + value2
                else if(opt == '-')
                    ans = value1 - value2
                else if(opt == '*')
                    ans = value1 * value2
                else if(opt == '/')
                    ans = value1 / value2

                text3.setText(ans.toString())
                flag = true
            }

            R.id.btnDel -> {
                val str: String = text3.getText().toString()

                if(str.isNotEmpty())
                    text3.text = str.substring(0, str.length-1)

            }


        }

    }
}
