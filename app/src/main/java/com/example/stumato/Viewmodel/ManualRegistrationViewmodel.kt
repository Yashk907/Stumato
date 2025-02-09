package com.example.stumato.Viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stumato.data.RepoImp
import com.example.stumato.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManualRegistrationViewmodel @Inject constructor (private val repoImp: RepoImp): ViewModel(){

    fun ManualRegister(firstName : String,
                       lastName : String,
                       mobileNumber : String){
        //this function takes the users credentials and stored in repository
        val user = User(
            firstName = firstName,
            lastName = lastName,
            mobileNumber = mobileNumber
        )
        viewModelScope.launch{
            repoImp.RegisterUserManual(user)
        }

    }

}