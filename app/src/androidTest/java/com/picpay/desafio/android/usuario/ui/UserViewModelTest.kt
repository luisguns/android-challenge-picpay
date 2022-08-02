package com.picpay.desafio.android.usuario.ui

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.nhaarman.mockitokotlin2.mock

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserViewModelTest {

    @get:Rule
    var instantExecutorRule = ActivityTestRule(MainActivity::class.java)



    @Test
    fun viewModelReturnList_GetIt() {
        launchActivity<MainActivity>().apply {

        }

    }
}