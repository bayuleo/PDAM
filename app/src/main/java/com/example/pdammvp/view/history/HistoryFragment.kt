package com.example.pdammvp.view.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.pdammvp.R
import com.example.pdammvp.databinding.FragmentHistoryBinding
import com.example.pdammvp.models.pojo.History
import com.example.pdammvp.models.pojo.Product
import com.example.pdammvp.view.history.adapter.HistoryAdapter
import com.example.pdammvp.view.home.HomeContract


class HistoryFragment : Fragment(), HistoryContract.View {

    var historuList : MutableList<History> = mutableListOf()
    private lateinit var mBinding : FragmentHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var presenter: HistoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)

        initPresenter()
        initLayout()

        presenter.getDataHistory()

        return  mBinding.root
    }

    private fun initPresenter() {
        presenter = HistoryPresenter(this)
    }

    private fun initLayout() {

        mBinding.rvHistory.layoutManager = LinearLayoutManager(requireContext())
        historyAdapter = HistoryAdapter(requireContext(), historuList)
        mBinding.rvHistory.adapter = historyAdapter
    }

    override fun onSuccessGetDataHistory(list: List<History>) {
        historyAdapter.updateData(list as MutableList<History>)
        historyAdapter.notifyDataSetChanged()
    }

    override fun onFailedGetDataHistory(message: String?) {
    }

}
