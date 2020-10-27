package com.example.application2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

private const val INT_STATE = 1;
private const val STRING_STATE = 2;
private var state: Int = INT_STATE;

private const val STATE_KEY: String = "State";

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*if (savedInstanceState != null) {
            state = savedInstanceState.getInt(STATE_KEY)
        }*/

        if (fragment_place != null) {
            setFragment(IntSum.newInstance())
            state = INT_STATE

            switch_fragment_button.setOnClickListener {
                if (state == INT_STATE) {
                    setFragment(StringSum.newInstance())
                    state = STRING_STATE
                }
                else if (state == STRING_STATE) {
                    setFragment(IntSum.newInstance())
                    state = INT_STATE
                }
            }
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(fragment_place.id, fragment).commit()
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_KEY, state)
        super.onSaveInstanceState(outState)
    }*/
}