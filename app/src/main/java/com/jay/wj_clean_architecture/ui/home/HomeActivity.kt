package com.jay.wj_clean_architecture.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jay.wj_clean_architecture.R
import com.jay.wj_clean_architecture.databinding.ActivityHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: ActivityHomeBinding
    private val adapter: HomeAdapter by lazy {
        HomeAdapter {
            Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.recyclerView.adapter = adapter
    }

}