package com.example.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="wish_table")




data class Wish(
    @PrimaryKey(autoGenerate = true) //this auto increment of id.
    val id: Long=0L,
    @ColumnInfo(name="wish_title")
    val title:String="",
    @ColumnInfo(name="wish_desc")
    val description :String = ""



)
