package android.test.com.swqademo.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.test.com.swqademo.R
import android.test.com.swqademo.database
import android.test.com.swqademo.database.entities.Specialization
import android.test.com.swqademo.showMessage
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val subSpecalizationList = listOf(
            // engineers
            Specialization(specializationName = "Mechanical Engineer", specializationParent = "Engineer"),
            Specialization(specializationName = "Computer Engineer", specializationParent = "Engineer"),
            Specialization(specializationName = "Civil Engineer", specializationParent = "Engineer"),
            Specialization(specializationName = "Electronics Engineer", specializationParent = "Engineer"),
            Specialization(specializationName = "Instrumental Engineer", specializationParent = "Engineer"),
            Specialization(specializationName = "Chemical Engineer", specializationParent = "Engineer"),
            Specialization(specializationName = "Aeronautical Engineer", specializationParent = "Engineer"),
            Specialization(specializationName = "Biochemical Engineer", specializationParent = "Engineer"),
            Specialization(specializationName = "Mining Engineer", specializationParent = "Engineer"),
            Specialization(specializationName = "Agricultural Engineer", specializationParent = "Engineer"),
            // Doctor
            Specialization(specializationName = "Cardiologist", specializationParent = "Doctor"),
            Specialization(specializationName = "Anesthesiologists", specializationParent = "Doctor"),
            Specialization(specializationName = "Dermetologist", specializationParent = "Doctor"),
            Specialization(specializationName = "Neuro Surgeon", specializationParent = "Doctor"),
            Specialization(specializationName = "Plastic Surgeon", specializationParent = "Doctor"),
            Specialization(specializationName = "Psychiatrists", specializationParent = "Doctor"),
            Specialization(specializationName = "Urologist", specializationParent = "Doctor"),
            //Special forces
            Specialization(specializationName = "Army", specializationParent = "Special Forces"),
            Specialization(specializationName = "Navy", specializationParent = "Special Forces"),
            Specialization(specializationName = "NSG", specializationParent = "Special Forces"),
            Specialization(specializationName = "Black Cat", specializationParent = "Special Forces"),
            Specialization(specializationName = "Air Force", specializationParent = "Special Forces"),
            Specialization(specializationName = "Police", specializationParent = "Special Forces"),
            Specialization(specializationName = "BSF", specializationParent = "Special Forces")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signUpText.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        loginButton.setOnClickListener { getUser() }
        val isTableEmpty = database.specializationDao().isSpecTableEmpty()
        if (isTableEmpty <= 0) {
            Thread().run { database.specializationDao().insetAllSubSpecializations(subSpecalizationList) }
        }
    }

    private fun getUser() {

        if (emailEditText.text.toString().trim().isNotBlank() && passwordEditText.text.toString().trim().isNotBlank()) {
            val user = database.userDao().getUser(emailEditText.text.toString(), passwordEditText.text.toString())

            if (user.isNotEmpty()) {
                finishAllActivities()
                finish()
            } else {
                showMessage("Email or Password incorrect.")
            }
        } else {
            showMessage("Please enter email and password")
        }
    }

    private fun finishAllActivities() {
        val homeIntent = Intent(this, HomeActivity::class.java)
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(homeIntent)
        finish()
    }
}
