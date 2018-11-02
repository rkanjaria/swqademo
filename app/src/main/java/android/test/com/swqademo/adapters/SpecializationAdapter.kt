package android.test.com.swqademo.adapters

import android.support.v7.widget.RecyclerView
import android.test.com.swqademo.R
import android.test.com.swqademo.inflate
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.specilization_recycler_layout.view.*

class SpecializationAdapter(val specializationList: List<String>) : RecyclerView.Adapter<SpecializationAdapter.SpecializationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SpecializationViewHolder {
        return SpecializationViewHolder(parent.inflate(R.layout.specilization_recycler_layout))
    }

    override fun getItemCount() = specializationList.size

    override
    fun onBindViewHolder(holder: SpecializationViewHolder, position: Int) {
        holder.bindViews(specializationList[position])
    }

    inner class SpecializationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view = itemView
        fun bindViews(specilizationName: String) {
            view.specilizationText.text = specilizationName
        }

    }
}