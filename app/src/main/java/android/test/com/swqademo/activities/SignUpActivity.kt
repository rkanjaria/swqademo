package android.test.com.swqademo.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.test.com.swqademo.R
import android.test.com.swqademo.database
import android.test.com.swqademo.database.entities.User
import android.test.com.swqademo.showMessage
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUpButton.setOnClickListener { signUpUser() }
    }

    private fun signUpUser() {
        if (nameText.text.toString().trim().isNotBlank() && emailText.text.toString().trim().isNotBlank() && passwordText.text.toString().trim().isNotBlank()) {
            database.userDao().addUser(User(fullName = nameText.text.toString().trim(),
                    email = emailText.text.toString().trim(), password = passwordText.text.toString().trim()))
            showMessage("Signup Successfull")
            finish()
        } else {
            showMessage("Please enter all fields to signup.")
        }
    }
}
