package com.example.application2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_int_sum.*
import kotlinx.android.synthetic.main.fragment_string_sum.*
import kotlinx.android.synthetic.main.fragment_string_sum.resultText
import kotlinx.android.synthetic.main.fragment_string_sum.sumButton

class StringSum : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sumButton.setOnClickListener {
            if (firstText.text.isEmpty() || secondText.text.isEmpty()) {
                //showSnackbar(it, getString(R.string.empty_field_err))
                return@setOnClickListener
            }

            val result = getString(R.string.result) +
                    firstText.text.toString() +
                    secondText.text.toString()
            resultText.text = result

            //showSnackbar(it, result)
        }

        return inflater.inflate(R.layout.fragment_string_sum, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            StringSum().apply {  }
    }

    /*private fun showSnackbar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }*/
}