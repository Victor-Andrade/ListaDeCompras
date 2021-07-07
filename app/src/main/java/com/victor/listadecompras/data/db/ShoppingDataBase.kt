package com.victor.listadecompras.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.victor.listadecompras.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDataBase: RoomDatabase() {
    abstract fun getShoppingDao(): ShoppingDAO

    companion object{
        @Volatile
        private var instance: ShoppingDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
            //If we don't have an instance, it will be created and saved in the companion object
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDataBase::class.java, "ShoppingDB.db").build()
    }

}