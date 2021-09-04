package com.breakingbad.trial.base.di

import android.app.Application
import com.breakingbad.trial.base.BreakingBadApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class
])
interface AppComponent : AndroidInjector<BreakingBadApplication>{
    override fun inject(application: BreakingBadApplication)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}