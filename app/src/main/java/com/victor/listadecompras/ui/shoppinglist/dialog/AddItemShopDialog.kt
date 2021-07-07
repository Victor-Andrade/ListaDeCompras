package com.victor.listadecompras.ui.shoppinglist.dialog

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.victor.listadecompras.R
import com.victor.listadecompras.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*
import kotlinx.android.synthetic.main.shopping_item.*

class AddItemShopDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        confirmButton.setOnClickListener{
            val name = nameEditText.text.toString()
            val amount = amountEditText.text.toString()
            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "Fill all the parameters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val shoppingItem = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(shoppingItem)
            dismiss()
        }

        cancelButton.setOnClickListener{
            cancel()
        }
    }
}