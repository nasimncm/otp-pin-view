package com.app.otppinviewcustom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pinDigit1 = findViewById<AppCompatEditText>(R.id.pinDigit1)
        val pinDigit2 = findViewById<AppCompatEditText>(R.id.pinDigit2)
        val pinDigit3 = findViewById<AppCompatEditText>(R.id.pinDigit3)
        val pinDigit4 = findViewById<AppCompatEditText>(R.id.pinDigit4)
        val pinDigit5 = findViewById<AppCompatEditText>(R.id.pinDigit5)
        val pinDigit6 = findViewById<AppCompatEditText>(R.id.pinDigit6)

        pinDigit1.addTextChangedListener(PinTextWatcher(pinDigit1, pinDigit2))
        pinDigit2.addTextChangedListener(PinTextWatcher(pinDigit2, pinDigit3))
        pinDigit3.addTextChangedListener(PinTextWatcher(pinDigit3, pinDigit4))
        pinDigit4.addTextChangedListener(PinTextWatcher(pinDigit4, pinDigit5))
        pinDigit5.addTextChangedListener(PinTextWatcher(pinDigit5, pinDigit6))
        pinDigit6.addTextChangedListener(PinTextWatcher(pinDigit6, null))
        pinDigit2.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && pinDigit2.text!!.isEmpty()) {
                pinDigit1.requestFocus()
            }
            false
        }
        pinDigit3.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && pinDigit3.text!!.isEmpty()) {
                pinDigit2.requestFocus()
            }
            false
        }
        pinDigit4.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && pinDigit4.text!!.isEmpty()) {
                pinDigit3.requestFocus()
            }
            false
        }
        pinDigit5.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && pinDigit5.text!!.isEmpty()) {
                pinDigit4.requestFocus()
            }
            false
        }
        pinDigit6.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && pinDigit6.text!!.isEmpty()) {
                pinDigit5.requestFocus()
            }
            false
        }

        val otp = "${pinDigit1.text}${pinDigit2.text}${pinDigit3.text}${pinDigit4.text}${pinDigit5.text}${pinDigit6.text}"

    }

    inner class PinTextWatcher(
        private val currentView: AppCompatEditText,
        private val nextView: AppCompatEditText?
    ) :
        TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (s?.length == 1) {
                nextView?.requestFocus()
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}


    }
}