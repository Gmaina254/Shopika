package com.example.shopika

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG

import android.view.LayoutInflater
import com.example.shopika.R
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopika.databinding.ItemBinding

class ItemAdapter(
    private val items : MutableList<Item>
) :RecyclerView.Adapter<ItemAdapter.ProductViewHolder>() {

    class ProductViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }


    fun addItem(item : Item){
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun deleteDoneItem(){
        items.removeAll{item ->
            item.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeTrough(tvItemTitle: TextView, isChecked: Boolean){
        if(isChecked){
            tvItemTitle.paintFlags = tvItemTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvItemTitle.paintFlags = tvItemTitle.paintFlags and STRIKE_THRU_TEXT_FLAG
        }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val curItem = items[position]
        holder.binding.apply {
            tvItemTitle.text = curItem.item
            tvCountItems.text = curItem.quantity
            cbDone.isChecked = curItem.isChecked
            toggleStrikeTrough(tvItemTitle, curItem.isChecked)
            cbDone.setOnCheckedChangeListener{_, isChecked ->
                toggleStrikeTrough(tvItemTitle, isChecked)
                curItem.isChecked = !curItem.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}