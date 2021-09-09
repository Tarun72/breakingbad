package com.breakingbad.trial.characters.repository

import androidx.lifecycle.LiveData
import com.breakingbad.trial.characters.ResponseCharacter
import com.breakingbad.trial.network.BreakingBadApi
import com.mine.mvvmmitch.utill.GenericApiResponse
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val breakingBadApi: BreakingBadApi
) {
    fun testCharacterApi(): GenericApiResponse<LiveData<ResponseCharacter>> {
        return breakingBadApi.getCharacters()
    }
}