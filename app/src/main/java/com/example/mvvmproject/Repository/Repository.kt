package com.example.mvvmproject.Repository

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmproject.DataModels.*
import com.example.mvvmproject.RetroApi.RetrofitApi
import com.example.mvvmproject.Database.UserDatabase
import retrofit2.Response

class Repository(val retrofitApi: RetrofitApi, val database: UserDatabase) {

    var usersdata = MutableLiveData<User_Details>()

    val livedatao: LiveData<User_Details>
        get() = usersdata

    suspend fun getUsers_Details(
        patient_id: Fetch_UsersDetails,
        context: Context
    ): Response<User_Details> {
        val result = retrofitApi.getUsersData(patient_id)
        Handler(Looper.getMainLooper()).post(Runnable {
            Toast.makeText(
                context,
                result.body()?.email.toString() + "hello world",
                Toast.LENGTH_SHORT
            ).show()
        })
        return result
    }

    var userLivedata = MutableLiveData<UserDataResponse>()
    val dataob: LiveData<UserDataResponse>
        get() = userLivedata


    suspend fun getLoginStatusRepo(userModel: LoginRequestModel, context: Context) : UserDataResponse {
        val result = retrofitApi.getLoginStatus(userModel)
        if (result.body() != null) {
            userLivedata.postValue(result.body())
           database.getDao().insertUserData(result.body()!!)
            Handler(Looper.getMainLooper()).post(Runnable {
                Toast.makeText(
                    context,
                    "success in repository" + result.body()?.data?.doctor_name,
                    Toast.LENGTH_SHORT
                ).show()
            })
        } else {
            Handler(Looper.getMainLooper()).post(Runnable {
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
            })
        }
        return result.body()!!
    }



}