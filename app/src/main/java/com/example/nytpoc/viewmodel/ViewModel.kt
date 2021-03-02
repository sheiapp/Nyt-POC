package com.example.nytpoc.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nytpoc.model.Results
import com.example.nytpoc.repository.Repository
import com.example.nytpoc.utils.Coroutines
import com.example.nytpoc.utils.Event
import com.example.nytpoc.utils.Resource
import com.example.nytpoc.utils.Status
import kotlinx.coroutines.Job

class ViewModel @ViewModelInject constructor(private val mostPopularApiRepo: Repository) :
    ViewModel() {
    private lateinit var getApiDataJob: Job
    private val _nytResultData = MutableLiveData<Event<List<Results>>>()
    val nytResultData: LiveData<Event<List<Results>>> get() = _nytResultData
    private val _userClickedData = MutableLiveData<Event<Results>>()
    val userClickedData: LiveData<Event<Results>> get() = _userClickedData
    private val _apiCallStatus: MutableLiveData<Event<Resource<Any>>> = MutableLiveData()
    val apiCallStatus :LiveData<Event<Resource<Any>>> get() = _apiCallStatus



    fun userClickedData(results: Results) {
        _userClickedData.value = Event(results)
    }


    fun getApiData() {
        _apiCallStatus.value = Event(Resource(Status.LOADING))
        getApiDataJob = Coroutines.ioThenMain({
            mostPopularApiRepo.getApiResponse()
        },
            {
                _apiCallStatus.value = Event(Resource(status = it?.status, message = it?.message))
                if (it?.status == Status.SUCCESS) {
                    it.data?.results?.let { data ->
                        _nytResultData.value = Event(data)
                    }
                }
            }, {
                _apiCallStatus.value = Event(Resource(Status.ERROR, it?.let { msg -> error(msg) }))
            })
    }


    override fun onCleared() {
        super.onCleared()
        if (::getApiDataJob.isInitialized) getApiDataJob.cancel()
    }

}