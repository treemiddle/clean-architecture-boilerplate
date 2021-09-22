package com.jay.wj_clean_architecture.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.jay.wj_clean_architecture.R
import com.jay.wj_clean_architecture.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: ActivityHomeBinding
//    private val binding: ActivityHomeBinding by lazy {
//        DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home).apply {
//            binding.lifecycleOwner = this@HomeActivity
//            binding.vm = viewModel
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    }
}