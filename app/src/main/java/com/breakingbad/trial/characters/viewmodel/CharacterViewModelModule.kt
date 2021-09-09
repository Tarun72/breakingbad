package com.breakingbad.trial.characters.viewmodel

import androidx.lifecycle.ViewModel
import com.breakingbad.trial.base.di.viewmodel.ViewModelKey
import com.breakingbad.trial.characters.viewmodel.CharacterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CharacterViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    abstract fun bindAuthViewModel(characterViewModel: CharacterViewModel): ViewModel

}