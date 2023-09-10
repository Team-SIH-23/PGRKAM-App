package com.assignment.pgrkam_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.pgrkam_app.databinding.FragmentCounsellingBinding
import com.assignment.pgrkam_app.models.Counsellor
import com.assignment.pgrkam_app.models.SearchCounsellor
import com.assignment.pgrkam_app.ui.adapter.AllCounsellingAdapter
import com.assignment.pgrkam_app.ui.adapter.SearchCounsellorAdapter

class CounsellingFragment : Fragment() {

    private lateinit var binding: FragmentCounsellingBinding
    private var counsellorList = arrayListOf<Counsellor>()
    private lateinit var counsellorAdapter : AllCounsellingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounsellingBinding.inflate(inflater, container, false)

        setUpSearchAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val counsellingType = arrayListOf(
            "Career Counselling",
            "Vocational Counselling",
            "Motivational Counselling",
            "Foreign Counselling",
            "Foreign Study Counselling"
        )

        val modeOfSession = arrayListOf(
            "Telephonic",
            "In person",
            "Web/Chat"
        )

        val educational = arrayListOf(
            "No Schooling",
            "5th",
            "8th",
            "10th",
            "12th",
            "Diploma After 10th",
            "Diploma After 12th",
            "ITI",
            "Graduate",
            "PG Diploma",
            "Post Graduate",
            "M Phill",
            "Phd"
        )

        binding.etCounsellingType.setSimpleItems(counsellingType.toTypedArray())
        binding.etModeOfSession.setSimpleItems(modeOfSession.toTypedArray())
        binding.etEducation.setSimpleItems(educational.toTypedArray())
        binding.btnSearch.setOnClickListener {
            counsellorList.clear()
            counsellorList.add(Counsellor("Career Counselling","10:21AM - 11:11PM","23/01/23"))
            counsellorList.add(Counsellor("Foreign Counselling","12:00AM - 11:00PM","26/11/14"))
            counsellorList.add(Counsellor("Vocational Counselling","7:00PM - 12:00PM","11/12/25"))
            counsellorAdapter.notifyDataSetChanged()
        }
    }

    private fun setUpSearchAdapter() {
        counsellorAdapter = AllCounsellingAdapter(counsellorList)
        binding.rvAllCounselling.adapter = counsellorAdapter
        binding.rvAllCounselling.layoutManager = LinearLayoutManager(requireContext())
    }

}