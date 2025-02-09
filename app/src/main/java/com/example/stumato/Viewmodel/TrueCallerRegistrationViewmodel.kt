package com.example.stumato.Viewmodel

import androidx.lifecycle.ViewModel
import com.example.stumato.data.RepoImp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrueCallerRegistrationViewmodel @Inject constructor(private val repoImp: RepoImp) : ViewModel() {

}