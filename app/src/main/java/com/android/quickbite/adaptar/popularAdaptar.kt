package com.android.quickbite.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.quickbite.databinding.PopularItemBinding

class popularAdaptar(private val items: List<String>, private val price: List<String>,private val images:List<Int>): RecyclerView.Adapter<popularAdaptar.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item= items[position]
        val price = price[position]
        val image = images[position]
        holder.bind(item,price,image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PopularViewHolder (private val binding: PopularItemBinding): RecyclerView.ViewHolder(binding.root){
        val imageView = binding.imageView3
        fun bind(item: String,price:String, image: Int) {
            binding.foodNamePopular.text = item
            binding.pricePolpular.text = price
            imageView.setImageResource(image)
        }

    }

}