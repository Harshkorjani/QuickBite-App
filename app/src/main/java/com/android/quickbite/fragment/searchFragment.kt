package com.android.quickbite.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.quickbite.R
import com.android.quickbite.adaptar.MenuAdapter
import com.android.quickbite.databinding.FragmentSearchBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class searchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val orignalMenuFoodName = listOf(
        "Burger","sandwich","momo","noodle","coffee","pasta","Burger","sandwich","momo","noodle"
    )
    private val orignalMenuItemPrice = listOf("$5","$6","$2","$2","$3","$5","$5","$6","$2","$2")
    private val orignalMenuImage = listOf(
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filterMenuFoodName = mutableListOf<String>()
    private val filterMenuItemPrice = mutableListOf<String>()
    private val filterMenuImage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filterMenuFoodName,filterMenuItemPrice,filterMenuImage)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        setupSearchView()
        showAllmenu()
        return binding.root
    }

    private fun showAllmenu() {
        filterMenuFoodName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        filterMenuFoodName.addAll(orignalMenuFoodName)
        filterMenuItemPrice.addAll(orignalMenuItemPrice)
        filterMenuImage.addAll(orignalMenuImage)
        adapter.notifyDataSetChanged()

    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

            private fun filterMenuItems(query: String?) {
                filterMenuFoodName.clear()
                filterMenuItemPrice.clear()
                filterMenuImage.clear()

                orignalMenuFoodName.forEachIndexed { index, foodname ->
                    if(foodname.contains(query.toString(), ignoreCase = true)){
                        filterMenuFoodName.add(foodname)
                        filterMenuItemPrice.add(orignalMenuItemPrice[index])
                        filterMenuImage.add(orignalMenuImage[index])
                    }
                    
                }
                adapter.notifyDataSetChanged()
            }
        })
    }

    companion object {

    }
}
