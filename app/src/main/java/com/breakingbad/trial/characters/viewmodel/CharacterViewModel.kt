package com.breakingbad.trial.characters.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.breakingbad.trial.characters.ResponseCharacter
import com.breakingbad.trial.characters.repository.CharacterRepository
import com.mine.mvvmmitch.utill.GenericApiResponse
import javax.inject.Inject

class CharacterViewModel @Inject
constructor(val characterRepository: CharacterRepository) :
    ViewModel() {

        fun testCharacterApi(): GenericApiResponse<LiveData<ResponseCharacter>> {
            return characterRepository.testCharacterApi()
        }
}