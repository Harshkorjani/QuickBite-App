package com.android.quickbite.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.quickbite.R
import com.android.quickbite.adaptar.cartAdapter
import com.android.quickbite.databinding.FragmentCartBinding

class cartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName = listOf("Burger","sandwich","momo","noodle","coffee","pasta")
        val cartItemPrice = listOf("$5","$6","$2","$2","$3","$5")
        val cartImage = listOf(
            R.drawable.burger,
            R.drawable.sanwich,
            R.drawable.momo,
            R.drawable.noodle,
            R.drawable.coffee,
            R.drawable.pasta
        )
        val adapter = cartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            cartFragment().apply {

            }
    }
}