package com.example.mywishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mywishlistapp.data.Wish
import com.example.mywishlistapp.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository=Graph.wishRepository


) :ViewModel(){
      var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")



    fun onWishTitleChanged(newString: String){
        wishTitleState=newString
    }
    fun onWishDescriptionChanged(newString: String){
        wishDescriptionState=newString
    }




   lateinit var getAllWishes:Flow<List<Wish>> //important

    init {
        viewModelScope.launch {
            getAllWishes=wishRepository.getWish()
        }
    }

fun addWish(wish: Wish){

    viewModelScope.launch(Dispatchers.IO) {
        wishRepository.addWish(wish=wish)
    }
}
    fun getAWishById(id:Long):Flow<Wish> {
        return wishRepository.getAWishById(id)

    }
    fun UpdateWish(wish: Wish){

        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateWish(wish=wish)
        }
    }

    fun deleteWish(wish: Wish){

        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish=wish)
        }
    }
}
// in view mdoel we store all data..............as like here we are here storing data.