package com.example.nytpoc.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.nytpoc.repository.RepoTest
import com.example.nytpoc.util.MainCoroutineRule
import com.example.nytpoc.util.getOrAwaitValueTest
import com.example.nytpoc.utils.Status
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ViewModel
    private lateinit var repoTest: RepoTest

    @Before
    fun setUp() {
        repoTest = RepoTest()
        viewModel = ViewModel(repoTest)
    }

    @Test
    fun checkErrorAPIValidation() {
        repoTest.setShouldReturnNetworkError(true)
        viewModel.getApiData()
        val data = viewModel.apiCallStatus.getOrAwaitValueTest()
        data.getContentIfNotHandled()?.let { results ->
            assertThat(results.status).isEqualTo(Status.ERROR)
            assertThat(results.message).isNotEmpty()
        }
    }

    @Test
    fun checkErrorMessageAPIValidation() {
        repoTest.setShouldReturnNetworkError(true)
        viewModel.getApiData()
        val data = viewModel.apiCallStatus.getOrAwaitValueTest()
        data.getContentIfNotHandled()?.let { results ->
            assertThat(results.message).isNotEmpty()
        }
    }

    @Test
    fun checkAPIResponseDataIsNotNull() {
        repoTest.setShouldReturnNetworkError(false)
        viewModel.getApiData()
        val data = viewModel.nytResultData.getOrAwaitValueTest()
        data.getContentIfNotHandled()?.let {
            assertThat(it).isNotEmpty()
        }
    }

}