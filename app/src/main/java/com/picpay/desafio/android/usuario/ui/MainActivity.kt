package com.picpay.desafio.android.usuario.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.usuario.adapter.UserListAdapter
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.domain.model.User
import com.picpay.desafio.domain.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var adapter: UserListAdapter

    private val userViewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initData() {
        userViewModel.UserLiveData.value?.let {
            processDataResource(it)
            return
        }
        userViewModel.getUser()
    }

    override fun onResume() {
        super.onResume()
        registerObservers()
        initData()
    }

    private fun registerObservers() {
        userViewModel.UserLiveData.observe(this) { userResource ->
            processDataResource(userResource)
        }
    }

    private fun processDataResource(userResource: Resource<List<User>>) {
        binding.userListProgressBar.visibility = if (userResource is Resource.Loading) View.VISIBLE else View.GONE
        when (userResource) {
            is Resource.Success -> userResource.data?.let {
                adapter.users = it
            }
            is Resource.Error -> Toast.makeText(this, userResource.message, Toast.LENGTH_SHORT).show()
            else -> {}
        }
    }

    private fun initViews() {
        adapter = UserListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
