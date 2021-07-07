package com.victor.listadecompras.ui.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.victor.listadecompras.R
import com.victor.listadecompras.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentItem = items[position]
        holder.itemView.nameTextView.text = currentItem.name
        holder.itemView.amountTextView.text = currentItem.amount.toString()

        holder.itemView.addImageView.setOnClickListener {
            currentItem.amount++
            viewModel.upsert(currentItem)
        }

        holder.itemView.minusImageView.setOnClickListener {
            if(currentItem.amount > 0){
                currentItem.amount--
                viewModel.upsert(currentItem)
            }
        }

        holder.itemView.deleteImageView.setOnClickListener {
            viewModel.delete(currentItem)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}