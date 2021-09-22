package com.jay.wj_clean_architecture.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jay.data.WJRepositoryImpl
import com.jay.domain.repository.WJRepository
import com.jay.domain.usecase.WJUsecase
import com.jay.local.WJLocalDataSourceImpl
import com.jay.remote.remote.WJRemoteDataSourceImpl
import com.jay.wj_clean_architecture.R
import com.jay.wj_clean_architecture.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this
        binding.vm = viewModel
    }
}