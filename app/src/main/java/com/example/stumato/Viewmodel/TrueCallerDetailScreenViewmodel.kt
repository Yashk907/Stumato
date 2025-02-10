package com.example.stumato.Viewmodel

import androidx.lifecycle.ViewModel
import com.example.stumato.data.RepoImp
import com.example.stumato.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class TrueCallerScreenViewmodel @Inject constructor(private val repoImp: RepoImp) : ViewModel(){
    private val _userInfo = MutableStateFlow(User())
    val userInfo =_userInfo

    init {
        _userInfo.value=repoImp.user.value
    }

}