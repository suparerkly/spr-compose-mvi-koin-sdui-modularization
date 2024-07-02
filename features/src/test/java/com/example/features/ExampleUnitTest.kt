package com.example.features

import com.example.features.viewmodel.HomeViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Mock
    lateinit var homeViewModel: HomeViewModel

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
//        viewState = MyViewState()
//        myViewModel = MyViewModel(handle, useCase)
    }

    @Test
    fun checkCallApi(){
        homeViewModel.getHomeScreen()
    }
}