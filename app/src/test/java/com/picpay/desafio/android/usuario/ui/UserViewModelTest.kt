package com.picpay.desafio.android.usuario.ui


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.isA
import com.picpay.desafio.android.usuario.util.FakeUserList
import com.picpay.desafio.android.getOrAwaitValue
import com.picpay.desafio.android.usuario.repository.FakeErrorGetUserRepository
import com.picpay.desafio.android.usuario.repository.FakeSuccesGetUserRepository
import com.picpay.desafio.domain.usecase.GetUsersUseCase
import com.picpay.desafio.domain.utils.Resource
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserViewModelTest{

    lateinit var useCase: GetUsersUseCase

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `when get user return correct users ` () = runBlockingTest {

        //given
        useCase = GetUsersUseCase(FakeSuccesGetUserRepository())
        val viewModel = UserViewModel(useCase)

        //when
        viewModel.getUser()
        val user = viewModel.UserLiveData.getOrAwaitValue()

        //then
        assertEquals(user.data, FakeUserList.getFakeList())

    }

    @Test
    fun `when get user return error msg ` () = runBlockingTest {

        //given
        useCase = GetUsersUseCase(FakeErrorGetUserRepository())
        val viewModel = UserViewModel(useCase)

        //when
        viewModel.getUser()
        val user = viewModel.UserLiveData.getOrAwaitValue()

        //then
        assertTrue(user is Resource.Error)
        assertEquals(user.message, FakeErrorGetUserRepository.FAKE_MSG)

    }
}