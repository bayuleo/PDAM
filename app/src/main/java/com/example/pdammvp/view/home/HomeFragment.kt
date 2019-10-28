package com.example.pdammvp.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager

import com.example.pdammvp.R
import com.example.pdammvp.databinding.FragmentHomeBinding
import com.example.pdammvp.models.pojo.Product
import com.example.pdammvp.view.home.adapter.HomeAdapter

class HomeFragment : Fragment() {

    var productList : MutableList<Product> = mutableListOf()
    private lateinit var mBinding : FragmentHomeBinding
    private lateinit var homeAdapter : HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        initLayout()

        return  mBinding.root
    }

    private fun initLayout() {

        mBinding.rvHome.layoutManager = GridLayoutManager(requireContext(), 2)
        homeAdapter = HomeAdapter(requireContext(),productList)
        mBinding.rvHome.adapter = homeAdapter



    }

}
