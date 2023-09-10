package com.assignment.pgrkam_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.pgrkam_app.databinding.FragmentSearchCounsellorBinding
import com.assignment.pgrkam_app.models.SearchCounsellor
import com.assignment.pgrkam_app.ui.adapter.SearchCounsellorAdapter

class SearchCounsellorFragment : Fragment() {

    private lateinit var binding: FragmentSearchCounsellorBinding
    private var counsellorList = arrayListOf<SearchCounsellor>()
    private lateinit var counsellorAdapter : SearchCounsellorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchCounsellorBinding.inflate(inflater, container, false)

        setUpSearchAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(
            "Architecture and Planning",
            "Pure Science",
            "Medicine and Surgery",
            "Medicine and surgery"
        )
        binding.etAreaOfInterest.setSimpleItems(list.toTypedArray())

        binding.btnSearch.setOnClickListener {
            counsellorList.clear()
            counsellorList.add(SearchCounsellor("Aditya", "838382", "asdsahd@gmail.com", "Btech"))
            counsellorList.add(SearchCounsellor("Sukhveer","93493949","werhewuhuwe@gmail.com","BE civil engineer"))
            counsellorList.add(SearchCounsellor("Inderjeet Kaur","3434343433","sadfsjdfj@gmail.com","BA ,MA ,Hindi"))
            counsellorAdapter.notifyDataSetChanged()
        }

    }

    private fun setUpSearchAdapter() {
        counsellorAdapter = SearchCounsellorAdapter(counsellorList)
        binding.rvSearchList.adapter = counsellorAdapter
        binding.rvSearchList.layoutManager = LinearLayoutManager(requireContext())
    }
}