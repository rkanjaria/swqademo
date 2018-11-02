package android.test.com.swqademo.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.test.com.swqademo.R
import android.test.com.swqademo.adapters.SpecializationAdapter
import android.test.com.swqademo.database
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*


class HomeActivity : AppCompatActivity() {

    var specializationList = listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"

        specializationList = resources.getStringArray(R.array.specialization).toList()
        specSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, specializationList)
        specSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                getSpecializations(specializationList[position])
            }
        }
    }

    fun getSpecializations(selectedSpecialization: String) {
        val specializationList = database.specializationDao().getAllSpecializations(selectedSpecialization)
        setRecyclerView(specializationList)
    }

    private fun setRecyclerView(specializationList: List<String>) {
        specRecyclerview.setHasFixedSize(true)
        specRecyclerview.layoutManager = LinearLayoutManager(this)
        specRecyclerview.adapter = SpecializationAdapter(specializationList)
    }

}
