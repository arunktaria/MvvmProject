package com.example.mvvmproject.ViewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmproject.DataModels.LoginRequestModel
import com.example.mvvmproject.DataModels.UserDataResponse
import com.example.mvvmproject.DataModels.UserModel
import com.example.mvvmproject.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelClass(val repository: Repository, val context: Context) : ViewModel() {

    init {
        CoroutineScope(Dispatchers.IO)
            .launch {
                val userModel = LoginRequestModel(
                    "piyush18@gmail.com",
                    "12345678",
                    "patient",
                    "dfdfsasd5",
                    "android"
                )


            }

    }


    val muLivedata=MutableLiveData<UserDataResponse>()
    val userLiveData:LiveData<UserDataResponse>
    get() = muLivedata
  fun getUserLogin(ob: LoginRequestModel)
  {
      CoroutineScope(Dispatchers.IO).launch {
          muLivedata.postValue(repository.getLoginStatusRepo(ob,context))
      }
  }


    /*
    val userdataLive= MutableLiveData<UserDataResponse>()
    val usermutable:LiveData<UserDataResponse>
        get() = usermutable*/
fun getUserDatafromDb() : LiveData<UserDataResponse>
{
    return repository.database.getDao().getUserdata()
}





}