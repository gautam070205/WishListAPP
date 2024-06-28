package com.example.mywishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao:WishDao) {
    suspend fun addWish(wish: Wish){
        wishDao.addWish(wish)
    }
    fun getWish(): Flow<List<Wish>> = wishDao.getAllWish()

    fun getAWishById(id:Long) :Flow<Wish>{
        return wishDao.getAWishById(id)
    }
    suspend fun updateWish(wish: Wish){
         wishDao.updateWish(wish)
    }
    suspend fun deleteAWish(wish: Wish){
        wishDao.deleteAWish(wish)
    }

}
//suspend func imp;