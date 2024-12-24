package com.android.quickbite.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.quickbite.R
import com.android.quickbite.adaptar.BuyAgainAdapter
import com.android.quickbite.databinding.FragmentHistoryBlankBinding

class HistoryBlankFragment : Fragment() {
    private lateinit var binding:FragmentHistoryBlankBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBlankBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        setupRecyclerView()
        return binding.root
    }
    private fun setupRecyclerView(){
        val buyAgainFoodName = arrayListOf("Food 2", "Food 2", "Food 2")
        val buyAgainFoodPrice = arrayListOf("$8", "$9", "$10")
        val buyAgainFoodImage = arrayListOf(R.drawable.burger, R.drawable.momo, R.drawable.pasta)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
        binding.BuyAgainRecyclerView.adapter = buyAgainAdapter
        binding.BuyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
    companion object {

    }
}