package com.example.pdammvp.view.history

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.pdammvp.R
import com.example.pdammvp.databinding.FragmentHistoryBinding
import com.example.pdammvp.databinding.FragmentHomeBinding
import com.example.pdammvp.models.pojo.History
import com.example.pdammvp.view.history.adapter.HistoryAdapter


class HistoryFragment : Fragment() {

    var historuList : MutableList<History> = mutableListOf()
    private lateinit var mBinding : FragmentHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)

        initLayout()

        return  mBinding.root
    }

    private fun initLayout() {

        mBinding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
        historyAdapter = HistoryAdapter(requireContext(), historuList)
        mBinding.rvHistory.adapter = historyAdapter
    }

}
