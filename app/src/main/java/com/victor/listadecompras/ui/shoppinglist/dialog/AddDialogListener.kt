package com.victor.listadecompras.ui.shoppinglist.dialog

import com.victor.listadecompras.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}