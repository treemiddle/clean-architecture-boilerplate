package com.jay.wj_clean_architecture.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jay.domain.usecase.WJUsecase
import com.jay.wj_clean_architecture.mapper.WJMapper
import com.jay.wj_clean_architecture.model.WJViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: WJUsecase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _list = MutableLiveData<List<WJViewModel>>()
    val list: LiveData<List<WJViewModel>>
        get() = _list

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        useCase.getItems()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { showLoading() }
            .observeOn(Schedulers.computation())
            .map {
                it.map(WJMapper::mapToView)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { hideLoading() }
            .doOnError { hideLoading() }
            .subscribe {
                println("zzzz: $it")
                _list.value = it
            }
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