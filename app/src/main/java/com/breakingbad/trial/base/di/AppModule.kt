package com.breakingbad.trial.base.di

import com.breakingbad.trial.util.Constants
import com.breakingbad.trial.util.LiveDataCallAdapterFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.google.gson.GsonBuilder




@Module
class AppModule {


    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
      return GsonBuilder()
            .setLenient()
            .create()
    }
      /**
     * For these cases where @Inject is insufficient or awkward,
     * use an @Provides-annotated method to satisfy a dependency.
     * The method’s return type defines which dependency it satisfies.
     *
     * */
    @Singleton
    @Provides
    fun provideRetrofitBuilder(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
}
/**
 *
 * So the execution flow in a dagger app would be:
 * The android app starts and the MyApplication class builds the graph,
 * parsing the @Module annotated classes and keeping an instance of it.
 * Then, the classes declared in the module can access its objects just injecting themselves in the object graph.
 * Gradle then will evaluate their @Inject annotations and perform the dependency injections.
 *
 * */