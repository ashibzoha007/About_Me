package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val myName : MyName = MyName("Ashib Uz Zoha")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        //findViewById<Button>(R.id.edit_button).setOnClickListener {
        //    addNickname(it)
        // }
        binding.editButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        // val editText = findViewById<EditText>(R.id.edit_nickname)
        // val  nickNameTextView = findViewById<TextView>(R.id.nickname_text)


        // nickNameTextView.text = editText.text
        // editText.visibility = View.GONE
        // view.visibility = View.GONE
        // nickNameTextView.visibility = View.VISIBLE
        binding.apply {
            // nicknameText.text = editNickname.text
            myName?.nickname = nicknameEdit.text.toString()

            invalidateAll()
            editNickname.visibility = View.GONE
            editButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}