package com.example.shopika

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopika.databinding.ActivityTodayshoppingBinding
import java.util.regex.Pattern

private lateinit var itemAdapter: ItemAdapter

class Todayshopping : AppCompatActivity() {
    private lateinit var binding: ActivityTodayshoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodayshoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemAdapter = ItemAdapter(mutableListOf())

        binding.rvShopItems.adapter = itemAdapter
        binding.rvShopItems.layoutManager = LinearLayoutManager(this)

        binding.btnAdd.setOnClickListener{
            val itemTitle = binding.shoppingItem.text.toString()
            val itemQuantity = binding.itemQuantity.text.toString()
            if (itemTitle.isNotEmpty() && itemQuantity.isNotEmpty()){
                val shopItem = Item(itemTitle, itemQuantity)
                itemAdapter.addItem(shopItem)
                binding.shoppingItem.text?.clear()
                binding.itemQuantity.text?.clear()
            }
        }

// Set input filter to only allow numeric input for the quantity field
        binding.itemQuantity.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val pattern = Pattern.compile("[0-9]*")
            if (!pattern.matcher(source).matches()) {
                return@InputFilter ""
            }
            null
        })



        binding.btnDelete.setOnClickListener{
            itemAdapter.deleteDoneItem()
        }
    }
}
