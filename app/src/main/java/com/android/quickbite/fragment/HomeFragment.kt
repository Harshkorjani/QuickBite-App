package com.android.quickbite.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.quickbite.MenuBottomSheetFragment
import com.android.quickbite.R
import com.android.quickbite.adaptar.popularAdaptar
import com.android.quickbite.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.ViewAllmenu.setOnClickListener{
            val bootSheetDialouge = MenuBottomSheetFragment()
            bootSheetDialouge.show(parentFragmentManager,"Test")
        }
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagelist = ArrayList<SlideModel>()
        imagelist.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imagelist)
        imageSlider.setImageList(imagelist,ScaleTypes.FIT)

        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imagelist[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })
        val foodname = listOf("Burger","sandwich","momo","Noodles","Coffee","pasta")
        val price = listOf("$5","$6","$2","$2","$3","$5")
        val popularFoodItems = listOf(R.drawable.burger,R.drawable.sanwich,R.drawable.momo,R.drawable.noodle,R.drawable.coffee,R.drawable.pasta)
        val adapter = popularAdaptar(foodname,price,popularFoodItems)
        binding.popularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRecyclerView.adapter = adapter
    }
    companion object {

    }
}