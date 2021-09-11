package com.breakingbad.trial.characters.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.breakingbad.trial.characters.model.Character
import com.breakingbad.trial.characters.repository.CharacterRepository
import com.breakingbad.trial.util.GenericApiResponse
import javax.inject.Inject

class CharacterViewModel @Inject
constructor(private val characterRepository: CharacterRepository) :
    ViewModel() {

        fun testCharacterApi(): LiveData<GenericApiResponse<List<Character>>> {
            return characterRepository.testCharacterApi()
        }
}