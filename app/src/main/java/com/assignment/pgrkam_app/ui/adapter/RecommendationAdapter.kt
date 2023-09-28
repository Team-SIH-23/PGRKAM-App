package com.assignment.pgrkam_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.pgrkam_app.databinding.ItemJobRecommendationBinding
import com.assignment.pgrkam_app.models.RecommendationResponseItem

class RecommendationAdapter :
    RecyclerView.Adapter<RecommendationAdapter.RecommendationViewHolder>() {

    private var recommendationResponseItemList = ArrayList<RecommendationResponseItem>()

    inner class RecommendationViewHolder(private val binding: ItemJobRecommendationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recommendationResponseItem: RecommendationResponseItem) {
            binding.companyName.text ="Company: "+ recommendationResponseItem.company_name
            binding.govtPvt.text = "Govt/Pvt: "+recommendationResponseItem.govt
            binding.jobTitle.text = "Job Title: "+recommendationResponseItem.job_title
            binding.experience.text ="Experience: "+ recommendationResponseItem.experience
            binding.vacancy.text = "Vacancy: "+recommendationResponseItem.vacancy
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val binding =
            ItemJobRecommendationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        val recommendationResponseItem = recommendationResponseItemList[position]
        holder.bind(recommendationResponseItem)
    }

    override fun getItemCount(): Int {
        return recommendationResponseItemList.size
    }

    fun setRecommendationResponseItemList(data: List<RecommendationResponseItem>) {
        recommendationResponseItemList.clear()
        recommendationResponseItemList.addAll(data)
        notifyDataSetChanged()
    }
}