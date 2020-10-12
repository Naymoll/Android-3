package com.example.application2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

const val Result_key: String = "Result"

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            resultText.text = savedInstanceState.getString(Result_key)
        }

        sumButton.setOnClickListener {
            if (firstNumber.text.isEmpty() || secondNumber.text.isEmpty()) {
                showSnackbar(it, getString(R.string.empty_field_err))
                return@setOnClickListener
            }

            val firstVal = firstNumber.text.toString().toIntOrNull(10)
            val secondVal = secondNumber.text.toString().toIntOrNull(10)

            if (firstVal == null || secondVal == null) {
                showSnackbar(it, getString(R.string.wrong_number_err))
                return@setOnClickListener
            }

            val result = getString(R.string.result) + (firstVal + secondVal).toString()
            resultText.text = result

            showSnackbar(it, result)
        }
    }

    private fun showSnackbar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(Result_key, resultText.text.toString())
        super.onSaveInstanceState(outState)
    }
}