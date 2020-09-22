package kirky.santos.basiccalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    var op = "*" //operation; set default only
    var oldNum = ""
    var isNewOp = true //boolean for new operation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun numEvent(view: View){   //function for clicking numbers and display on screen
        if(isNewOp){
            etShowNum.setText("")
        }
        isNewOp = false
        val enteredNum = etShowNum.text.toString()
        val btnSelected = view as Button
        var clickedNum: String = enteredNum
        when(btnSelected.id){
            btn0.id ->{
                clickedNum+="0"
            }
            btn1.id ->{
                clickedNum+="1"
            }
            btn2.id ->{
                clickedNum+="2"
            }
            btn3.id ->{
                clickedNum+="3"
            }
            btn4.id ->{
                clickedNum+="4"
            }
            btn5.id ->{
                clickedNum +="5"
            }
            btn6.id ->{
                clickedNum+="6"
            }
            btn7.id ->{
                clickedNum+="7"
            }
            btn8.id ->{
                clickedNum+="8"
            }
            btn9.id ->{
                clickedNum+="9"
            }
            btnDecimal.id ->{
                if(etShowNum.text.toString().contains(".")){
                    clickedNum+=""
                }
                else{
                    clickedNum+="."
                }
            }

            btnPlusMin.id ->{
                clickedNum= "-" +clickedNum
            }
        }
        etShowNum.setText(clickedNum)
    }

    fun operations(view: View) {    //function to specify which operation is clicked
        var btnSelected = view as Button
        when (btnSelected.id) {
            btnAdd.id -> {
                op = "+"
            }
            btnSubtract.id -> {
                op = "-"
            }
            btnMultiply.id -> {
                op = "*"
            }
            btnDivide.id -> {
                op = "/"
            }
        }
        oldNum = etShowNum.text.toString()
        isNewOp = true //set new operation when operation is clicked
    }

    fun equalsEvent(view: View){    //function to peform operation and show the result
        var newNum = etShowNum.text.toString()
        var resultNum: Double? = null
        when(op){
            "+" -> {
                resultNum = oldNum.toDouble() + newNum.toDouble()
            }
            "-" -> {
                resultNum = oldNum.toDouble() - newNum.toDouble()
            }
            "*" -> {
                resultNum = oldNum.toDouble() * newNum.toDouble()
            }
            "/" -> {
                resultNum = oldNum.toDouble() / newNum.toDouble()
            }
        }
        etShowNum.setText(resultNum.toString())
        isNewOp = true
    }

    fun allClear(view: View){   //AC function
        etShowNum.setText("")
        isNewOp = true
    }

    fun percentage(view: View){ //Percent function
        val percentNum = etShowNum.text.toString().toDouble()/100
        etShowNum.setText(percentNum.toString())
        isNewOp = true
    }
}