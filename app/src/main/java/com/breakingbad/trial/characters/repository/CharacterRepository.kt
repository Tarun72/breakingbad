package com.breakingbad.trial.characters.repository

import androidx.lifecycle.LiveData
import com.breakingbad.trial.characters.ResponseCharacter
import com.breakingbad.trial.characters.model.Character
import com.breakingbad.trial.network.BreakingBadApi
import com.mine.mvvmmitch.utill.GenericApiResponse
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CharacterRepository @Inject constructor(
    private val breakingBadApi: BreakingBadApi
) {
    fun testCharacterApi(): LiveData<GenericApiResponse<List<Character>>> {
        return breakingBadApi.getCharacters()
    }
}