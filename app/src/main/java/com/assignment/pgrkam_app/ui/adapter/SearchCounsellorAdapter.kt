package com.assignment.pgrkam_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.pgrkam_app.databinding.ItemSearchCounsellorListBinding
import com.assignment.pgrkam_app.models.SearchCounsellor

class SearchCounsellorAdapter(private val list: List<SearchCounsellor>) :
    RecyclerView.Adapter<SearchCounsellorAdapter.SearchCounsellorViewHolder>() {

    var onItemClick: ((SearchCounsellor) -> Unit)? = null

    inner class SearchCounsellorViewHolder(val binding: ItemSearchCounsellorListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchCounsellorViewHolder {
        return SearchCounsellorViewHolder(
            ItemSearchCounsellorListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SearchCounsellorViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.tvName.text = this.name
                binding.tvMobile.text = this.mobileName
                binding.tvEmail.text = this.email
                binding.tvQual.text = this.qualification
            }
        }
    }

}