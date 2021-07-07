package com.victor.listadecompras.di

import android.content.Context
import com.victor.listadecompras.data.db.ShoppingDataBase
import com.victor.listadecompras.data.repositories.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun repositoryProvider(db: ShoppingDataBase) : ShoppingRepository = ShoppingRepository(db)

    @Singleton
    @Provides
    fun databaseProvider(@ApplicationContext context: Context) : ShoppingDataBase =  ShoppingDataBase(context)

}