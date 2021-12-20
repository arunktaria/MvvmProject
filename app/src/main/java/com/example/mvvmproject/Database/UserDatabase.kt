package com.example.mvvmproject.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmproject.Dao.UserDao
import com.example.mvvmproject.DataModels.UserDataResponse
import com.example.mvvmproject.Entities.UserDataEntity

@Database(entities = [UserDataResponse::class], version = 1)
abstract class UserDatabase :RoomDatabase() {
abstract fun getDao() : UserDao
    companion object{
        @Volatile
        var database: UserDatabase?=null
        fun getInstanse(context: Context) : UserDatabase {
            if (database == null)
            {
                database=Room.databaseBuilder(context,UserDatabase::class.java,"db_UserDatabase").build()
            }
            return database as UserDatabase
        }

    }


}