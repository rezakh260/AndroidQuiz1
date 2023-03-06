package com.example.androidquiz1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class FirstViewModel: ViewModel(){



//     lateinit var username:String
//     lateinit var password:String

      val _username = MutableLiveData<String>()
     val username : LiveData<String> = _username

      val _password = MutableLiveData<String>()
     val password : LiveData<String> = _password



     fun saveUsernameAndPassword(username: String, password: String){

          _username.value = username
          _password.value = password


     }

}