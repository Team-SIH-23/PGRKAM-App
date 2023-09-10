package com.assignment.pgrkam_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.pgrkam_app.databinding.ItemAllCounsellingListBinding
import com.assignment.pgrkam_app.models.Counsellor

class AllCounsellingAdapter(private val list: List<Counsellor>) :
    RecyclerView.Adapter<AllCounsellingAdapter.AllCounsellingViewHolder>() {

    var onItemClick: ((Counsellor) -> Unit)? = null

    inner class AllCounsellingViewHolder(val binding: ItemAllCounsellingListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCounsellingViewHolder {
        return AllCounsellingViewHolder(
            ItemAllCounsellingListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AllCounsellingViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.textView.text = this.counsellorType
                binding.textView4.text = this.timing
                binding.tvDate.text = this.date
                binding.card.setOnClickListener {
                    onItemClick?.invoke(this)
                }
            }
        }
    }

}