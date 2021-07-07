package com.victor.listadecompras.ui.shoppinglist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.victor.listadecompras.R
import com.victor.listadecompras.data.db.entities.ShoppingItem
import com.victor.listadecompras.ui.shoppinglist.dialog.AddDialogListener
import com.victor.listadecompras.ui.shoppinglist.dialog.AddItemShopDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_shopping.*

@AndroidEntryPoint
class ShoppingActivity : AppCompatActivity() {
    private val viewModel: ShoppingViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        shoppingRecyclerView.layoutManager = LinearLayoutManager(this)
        shoppingRecyclerView.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        floatingActionButton.setOnClickListener{
            AddItemShopDialog(this, object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}