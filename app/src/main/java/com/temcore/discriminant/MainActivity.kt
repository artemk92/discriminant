package com.temcore.discriminant

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.temcore.discriminant.R
import java.lang.NumberFormatException
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    var a: EditText? = null
    var b: EditText? = null
    var c: EditText? = null
    var result: TextView? = null
    var countButt: Button? = null
    var resetButt: Button? = null
    var a_d = 0.0
    var b_d = 0.0
    var c_d = 0.0
    var d = 0.0
    var i = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a = findViewById(R.id.a)
        b = findViewById(R.id.b)
        c = findViewById(R.id.c)
        result = findViewById<View>(R.id.result) as TextView
        countButt = findViewById<View>(R.id.count) as Button
        resetButt = findViewById<View>(R.id.reset) as Button
    }

    fun onCountButtonClick(v: View?) {
        count()
    }

    fun onResetButtonClick(v: View?) {
        a?.setText("")
        b?.setText("")
        c?.setText("")
        result?.setText("")
    }

    private fun count() {
        try {
            a_d = toNumber(a)
            b_d = toNumber(b)
            c_d = toNumber(c)
            d = b_d * b_d - 4 * a_d * c_d
            i = sqrt(d)
            if (i == 0.0) {
                result!!.text = "x=" + -b_d / (2 * a_d)
            } else {
                if (i > 0) {
                    result!!.text = """
                        x1=${(-b_d + i) / (2 * a_d)}
                        x2=${(-b_d - i) / (2 * a_d)}
                        D=$d
                        """.trimIndent()
                } else {
                    result!!.setText(R.string.no)
                }
            }
        } catch (e: NumberFormatException) {
            result!!.setText(R.string.error)
        }
    }

    private fun toNumber(view: EditText?): Double {
        return view!!.text.toString().toDouble()
    }
}