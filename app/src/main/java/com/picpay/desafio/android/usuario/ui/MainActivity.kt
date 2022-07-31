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
import com.picpay.desafio.domain.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: UserListAdapter

    private val userViewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = binding.userListProgressBar


        adapter = UserListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.UserLiveData.observe(this) { userResourcec ->
            progressBar.visibility = if (userResourcec is Resource.Loading) View.VISIBLE else View.GONE
            when (userResourcec) {
                is Resource.Success -> userResourcec.data?.let {
                    adapter.users = it
                    binding.userListProgressBar.visibility = View.GONE
                }
                is Resource.Error -> Toast.makeText(this, userResourcec.message, Toast.LENGTH_SHORT).show()
                else -> {}
            }
        }
        userViewModel.getUser()
    }
}
