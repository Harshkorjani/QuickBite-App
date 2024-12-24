package com.android.quickbite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.quickbite.adaptar.NotificationAdapter
import com.android.quickbite.databinding.FragmentNotificationBottomFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Notification_Bottom_fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomFragmentBinding.inflate(layoutInflater,container,false)
        val notification = listOf("Your order has been canceled successfully", "Order has been take by the driver", "congrats! your order has placed")
        val notficationImage = listOf(R.drawable.sademoji, R.drawable.truck, R.drawable.congrats)
        val adapter = NotificationAdapter(
            ArrayList(notification),
            ArrayList(notficationImage),
        )
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}