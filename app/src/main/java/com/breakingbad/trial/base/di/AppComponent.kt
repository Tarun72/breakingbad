package com.breakingbad.trial.base.di

import android.app.Application
import com.breakingbad.trial.base.BreakingBadApplication
import com.breakingbad.trial.base.di.viewmodel.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    /**
     * Contains bindings to ensure the usability of {@code dagger.android} framework classes. This
     * module should be installed in the component that is used to inject the {@link
     * android.app.Application} class.
     */
    AndroidInjectionModule::class,
    ViewModelFactoryModule::class
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