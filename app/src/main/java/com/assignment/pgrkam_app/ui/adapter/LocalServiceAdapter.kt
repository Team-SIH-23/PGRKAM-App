package com.assignment.pgrkam_app.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.pgrkam_app.databinding.ItemLocalServiceBinding
import com.assignment.pgrkam_app.models.LocalService
import com.assignment.pgrkam_app.utils.GlideLoader
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalServiceAdapter @Inject constructor(
    @ApplicationContext val context: Context
) : RecyclerView.Adapter<LocalServiceAdapter.LocalServiceViewHolder>() {

    private var list = ArrayList<LocalService>()

    inner class LocalServiceViewHolder(private val binding: ItemLocalServiceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(localService: LocalService) {
            binding.serviceName.text = "Service Name: "+ localService.services_name
            binding.orgName.text = localService.org_name
            val glideLoader = GlideLoader(context)
            localService.profile_image?.let { glideLoader.loadImage(it, binding.circularIv) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalServiceViewHolder {
        val binding =
            ItemLocalServiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocalServiceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocalServiceViewHolder, position: Int) {
        val localService = list[position]
        holder.bind(localService)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setUpPinnedRepoList(list: List<LocalService>) {
        this.list = list.toMutableList() as ArrayList<LocalService>
        notifyDataSetChanged()
    }

}