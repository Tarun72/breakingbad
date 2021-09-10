package com.breakingbad.trial.base.di

import com.breakingbad.trial.CharacterActivity
import com.breakingbad.trial.characters.di.CharacterAppModule
import com.breakingbad.trial.characters.di.CharacterScope
import com.breakingbad.trial.characters.viewmodel.CharacterViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @CharacterScope
    @ContributesAndroidInjector(
        modules =[
            // View Model
            CharacterViewModelModule::class,
            CharacterAppModule::class
        ]
    )
    abstract fun contributeCharacterActivity(): CharacterActivity

}