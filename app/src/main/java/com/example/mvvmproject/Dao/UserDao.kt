package com.example.mvvmproject.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmproject.DataModels.UserDataResponse
import com.example.mvvmproject.Entities.UserDataEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insertUserData(user : UserDataResponse)

    @Query("select * from tbl_userdata")
     fun getUserdata() : LiveData<UserDataResponse>


}