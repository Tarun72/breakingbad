package com.breakingbad.trial

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.breakingbad.trial.base.BaseActivity
import com.breakingbad.trial.base.di.viewmodel.ViewModelProviderFactory
import com.breakingbad.trial.characters.viewmodel.CharacterViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModelProvider
import com.breakingbad.trial.base.TAG
import com.mine.mvvmmitch.utill.ApiEmptyResponse
import com.mine.mvvmmitch.utill.ApiErrorResponse
import com.mine.mvvmmitch.utill.ApiSuccessResponse


class CharacterActivity : BaseActivity() {
    @Inject
    lateinit var viewProvideFactoryModule: ViewModelProviderFactory
    lateinit var characterViewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        characterViewModel =
            ViewModelProvider(this, viewProvideFactoryModule).get(CharacterViewModel::class.java)
        characterViewModel.testCharacterApi().observe(this, Observer { response ->
            when (response) {
                is ApiEmptyResponse -> {
                    Log.d(TAG, "ApiEmptyResponse:")
                }
                is ApiErrorResponse -> {
                    Log.d(TAG, "ApiErrorResponse:${response.errorMessage} ")
                }
                is ApiSuccessResponse -> {
                    Log.d(TAG, "ApiSuccessResponse: ${response.body} ")
                }
            }
        })
    }
}