package com.assignment.pgrkam_app.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.pgrkam_app.databinding.ItemMostSuitableJobsListBinding
import com.assignment.pgrkam_app.models.GovtJobs
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MostSuitableJobsAdapter @Inject constructor(@ApplicationContext val context: Context) :
    RecyclerView.Adapter<MostSuitableJobsAdapter.MostSuitableJobsViewHolder>() {

    private var govtJobs = ArrayList<GovtJobs>()

    inner class MostSuitableJobsViewHolder(private val binding: ItemMostSuitableJobsListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(govtJobs: GovtJobs) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostSuitableJobsViewHolder {
        val binding = ItemMostSuitableJobsListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MostSuitableJobsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MostSuitableJobsViewHolder, position: Int) {
        val govJob = govtJobs[position]
        return holder.bind(govJob)
    }

    override fun getItemCount(): Int {
        return govtJobs.size
    }
}