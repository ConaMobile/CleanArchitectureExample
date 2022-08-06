package com.conamobile.cleanarchitectureexample.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.conamobile.cleanarchitectureexample.App
import com.conamobile.cleanarchitectureexample.R
import com.conamobile.cleanarchitectureexample.util.UserResource
import com.conamobile.cleanarchitectureexample.vm.UserViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: UserViewModel by viewModels { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {

            viewModel.getUsers().collect {
                when (it) {
                    is UserResource.Error -> {}
                    is UserResource.Success -> {
                        Log.d("@@@","${it.list}")
                    }
                    is UserResource.Loading -> {}
                }
            }
        }
    }
}