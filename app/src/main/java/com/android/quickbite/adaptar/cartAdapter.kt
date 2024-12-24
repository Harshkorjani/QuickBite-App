package com.android.quickbite.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.quickbite.databinding.CasrtLayoutBinding

class cartAdapter(private val cartItems: MutableList<String>,private val CartItemPrice: MutableList<String>, private var CartImage:MutableList<Int>) : RecyclerView.Adapter<cartAdapter.CartViewHolder>() {
    private val itemQuantites = IntArray(cartItems.size){1}
    inner class CartViewHolder(private  val binding: CasrtLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val quantity = itemQuantites[position]
            binding.apply {
                cartFoodName.text = cartItems[position]
                cartItemPrice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemQuantity.text = quantity.toString()

                minusCart.setOnClickListener{
                    decreaseQuantity(position)
                }
                plusCart.setOnClickListener {
                    increaseQuantity(position)
                }

                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION){
                        postionDelete(itemPosition)
                    }
                }
            }
        }
        private fun decreaseQuantity(position: Int){
            if(itemQuantites[position]>1){
                itemQuantites[position]--
                binding.cartItemQuantity.text = itemQuantites[position].toString()
            }
        }
        private fun increaseQuantity(position: Int) {
            if (itemQuantites[position] < 100) {
                itemQuantites[position]++
                binding.cartItemQuantity.text = itemQuantites[position].toString()
            }
        }
        private fun postionDelete(position: Int){
            cartItems.removeAt(position)
            CartItemPrice.removeAt(position)
            CartImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,cartItems.size)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CasrtLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int =  cartItems.size


    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
}


