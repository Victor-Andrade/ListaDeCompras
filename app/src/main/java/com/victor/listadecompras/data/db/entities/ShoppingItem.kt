package com.victor.listadecompras.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//Sample class for model with storage in DB
@Entity(tableName = "shopping_item")
data class ShoppingItem(
    val name: String,
    var amount: Int,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

/*
    The name of the variables in the db will be the same,
    if we wanted to change, we could do something link:
    @ColumnInfo(name = "CustomName")
    val name: String,
    var amount: Int,
 */