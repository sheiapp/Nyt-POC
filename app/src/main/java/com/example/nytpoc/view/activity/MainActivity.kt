package com.example.nytpoc.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.nytpoc.databinding.ActivityMainBinding
import com.example.nytpoc.utils.*
import com.example.nytpoc.viewmodel.ViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ViewModel>()
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeApiStatus()
    }

    private fun observeApiStatus(){
        viewModel.apiCallStatus.observe(this){
            it?.getContentIfNotHandled()?.let {resource->
                handleAPICallStatus(resource)
            }
        }
    }

    private fun handleAPICallStatus(resource: Resource<Any>) {
        when(resource.status){
            Status.LOADING ->
                binding.progressBar.visible()
            Status.ERROR-> {
                binding.progressBar.inVisible()
                resource.message?.let { binding.root.snack(it,Snackbar.LENGTH_LONG) }
            }
            else->
                binding.progressBar.inVisible()
        }
    }
}