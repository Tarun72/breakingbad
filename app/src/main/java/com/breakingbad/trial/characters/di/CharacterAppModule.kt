package com.breakingbad.trial.characters.di

import com.breakingbad.trial.characters.repository.CharacterRepository
import com.breakingbad.trial.network.BreakingBadApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


@Module
class CharacterAppModule {

    @CharacterScope
    @Provides
    fun provideInterceptor(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @CharacterScope
    @Provides
    fun provideBreakingBadApiService(retrofitBuilder: Retrofit.Builder,
                                    okHttpClient: OkHttpClient): BreakingBadApi {
        return retrofitBuilder
            .client(okHttpClient)
            .build()
            .create(BreakingBadApi::class.java)
    }


    @CharacterScope
    @Provides
    fun provideCharacterRepository(breakingBadApi: BreakingBadApi): CharacterRepository {
        return CharacterRepository(breakingBadApi = breakingBadApi)
    }
}