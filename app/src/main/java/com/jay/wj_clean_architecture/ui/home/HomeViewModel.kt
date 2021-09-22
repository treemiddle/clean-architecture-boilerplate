package com.jay.wj_clean_architecture.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jay.domain.usecase.WJUsecase
import com.jay.wj_clean_architecture.mapper.WJMapper
import com.jay.wj_clean_architecture.model.WJViewModel
import com.jay.wj_clean_architecture.utils.NotNullMutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class HomeViewModel(useCase: WJUsecase) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _list = MutableLiveData<List<WJViewModel>>(emptyList())
    val list: LiveData<List<WJViewModel>>
        get() = _list

    private val _isLoading = NotNullMutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        useCase.getSearchMovie("영화")
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { showLoading() }
            .observeOn(Schedulers.computation())
            .map { it.map(WJMapper::mapToView) }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { hideLoading() }
            .doOnError { hideLoading() }
            .subscribe { _list.value = it }
            .addTo(compositeDisposable)
    }

    private fun showLoading() {
        _isLoading.value = true
    }

    private fun hideLoading() {
        _isLoading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}