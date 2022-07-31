package com.picpay.desafio.android.usuario.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.domain.exception.Error
import com.picpay.desafio.domain.model.User
import com.picpay.desafio.domain.usecase.GetUsersUseCase
import com.picpay.desafio.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userUseCase: GetUsersUseCase) : ViewModel(){

    private val _userLiveData: MutableLiveData<Resource<List<User>>> = MutableLiveData()
    val UserLiveData = _userLiveData

    fun getUser() {
        viewModelScope.launch {
            userUseCase.execute().collect {
                    UserLiveData.value = it
                }
            }
        }
}