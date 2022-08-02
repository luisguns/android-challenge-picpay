package com.picpay.desafio.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.picpay.desafio.data.*
import com.picpay.desafio.domain.utils.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ImpGetUserRepositoryTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `when get user to repository return success and correct list use`() = runBlocking {

        //given
        val repos = ImpGetUserRepository(FakeGetUserNetworkDatasource(),FakeGetUserLocalDatasource())

        //when
        repos.getUsers().test {

            //then
            val resource = expectMostRecentItem()
            assertTrue(resource is Resource.Success)
            assertEquals(resource.data, FakeUserList.getFakeList())
        }
    }

    @Test
    fun `when get users and throw a Exception return Error`() = runBlocking{

        //given
        val repos = ImpGetUserRepository(FakeExceptionGetUserNetworkDatasource(),FakeGetUserLocalDatasource())

        //when
        repos.getUsers().test {
            val resource = expectMostRecentItem()

            //then
            assertTrue(resource is Resource.Error)
            assertEquals(resource.message, ImpGetUserRepository.NOT_IDENTIFY_EXCEPTION)
        }

    }

    @Test
    fun `when get user and throw a HttpException return Error`() = runBlocking{
        val repos = ImpGetUserRepository(FakeHttpExceptionGetUserNetworkDatasource(),FakeGetUserLocalDatasource())

        repos.getUsers().test {
            val resource = expectMostRecentItem()

            assertTrue(resource is Resource.Error)
            assertEquals(resource.message,
                FakeHttpExceptionGetUserNetworkDatasource.CODE_HTTP_FAKE_ERROR.toString())
        }
    }
}