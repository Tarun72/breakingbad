package com.breakingbad.trial.network

import androidx.lifecycle.LiveData
import com.breakingbad.trial.characters.ResponseCharacter
import com.breakingbad.trial.characters.model.Character
import com.mine.mvvmmitch.utill.GenericApiResponse
import retrofit2.http.GET

interface BreakingBadApi {

    @GET("characters")
    fun getCharacters(): LiveData<GenericApiResponse<List<Character>>>

}