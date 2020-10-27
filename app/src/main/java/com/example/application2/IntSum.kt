package com.example.application2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_int_sum.*

class IntSum : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        sumButton.setOnClickListener {
            if (firstNumber.text.isEmpty() || secondNumber.text.isEmpty()) {
                //showSnackbar(it, getString(R.string.empty_field_err))
                return@setOnClickListener
            }

            val firstVal = firstNumber.text.toString().toIntOrNull(10)
            val secondVal = secondNumber.text.toString().toIntOrNull(10)

            if (firstVal == null || secondVal == null) {
                //showSnackbar(it, getString(R.string.wrong_number_err))
                return@setOnClickListener
            }

            val result = getString(R.string.result) + (firstVal + secondVal).toString()
            resultText.text = result

            //showSnackbar(it, result)
        }
        return inflater.inflate(R.layout.fragment_int_sum, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            IntSum().apply {  }
    }

    /*private fun showSnackbar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }*/
}