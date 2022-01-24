package com.example.laerninglayouts

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.laerninglayouts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("rashmi ","singh")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myName = myName

        binding.button.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        binding.apply{
            textView.text = editText.text.toString()
            invalidateAll()
            editText.visibility = View.GONE
            view.visibility = View.GONE
            textView.visibility = View.VISIBLE
        }

        //hide keyboard
        (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
            view.windowToken,
            0
        )
    }
}