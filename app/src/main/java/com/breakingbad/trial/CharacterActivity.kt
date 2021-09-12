package com.breakingbad.trial

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.breakingbad.trial.base.BaseActivity
import com.breakingbad.trial.base.di.viewmodel.ViewModelProviderFactory
import com.breakingbad.trial.characters.viewmodel.CharacterViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.breakingbad.trial.characters.adapter.CharacterAdapter
import com.breakingbad.trial.characters.model.Character
import com.breakingbad.trial.databinding.ActivityCharacterBinding
import com.breakingbad.trial.util.ApiEmptyResponse
import com.breakingbad.trial.util.ApiErrorResponse
import com.breakingbad.trial.util.ApiSuccessResponse


class CharacterActivity : BaseActivity() {
    @Inject
    lateinit var viewProvideFactoryModule: ViewModelProviderFactory
    lateinit var characterViewModel: CharacterViewModel
    lateinit var characterBindingImpl : ActivityCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // data binding
         characterBindingImpl = DataBindingUtil.setContentView<ActivityCharacterBinding>(
            this,
            R.layout.activity_character
        )
        characterBindingImpl.lifecycleOwner = this

        characterViewModel =
            ViewModelProvider(this, viewProvideFactoryModule).get(CharacterViewModel::class.java)

        characterBindingImpl.characterViewModel = characterViewModel

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
                    initCharacterList(response.body)
                }
            }
        })
    }


   fun initCharacterList(characters :List<Character>){
       characterBindingImpl.rvCharacters.layoutManager = LinearLayoutManager(this)
       characterBindingImpl.rvCharacters.adapter = CharacterAdapter(characters)
    }
}