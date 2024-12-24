package com.android.quickbite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.quickbite.adaptar.MenuAdapter
import com.android.quickbite.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)
        binding.buttonBack.setOnClickListener {
            dismiss()
        }
        val menuFoodName = listOf("Burger","sandwich","momo","noodle","coffee","pasta","Burger","sandwich","momo","noodle")
        val MenuItemPrice = listOf("$5","$6","$2","$2","$3","$5","$5","$6","$2","$2")
        val MenuImage = listOf(
            R.drawable.burger,
            R.drawable.sanwich,
            R.drawable.momo,
            R.drawable.noodle,
            R.drawable.coffee,
            R.drawable.pasta,
            R.drawable.burger,
            R.drawable.sanwich,
            R.drawable.momo,
            R.drawable.noodle,
        )
        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(MenuItemPrice),ArrayList(MenuImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}