package com.breakingbad.trial.network

import androidx.lifecycle.LiveData
import com.breakingbad.trial.characters.ResponseCharacter
import com.mine.mvvmmitch.utill.GenericApiResponse
import retrofit2.http.GET

interface BreakingBadApi {

    @GET
    fun getCharacters():GenericApiResponse<LiveData<ResponseCharacter>>

}