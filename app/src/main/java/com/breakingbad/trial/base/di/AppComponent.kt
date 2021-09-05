package com.breakingbad.trial.base.di

import android.app.Application
import com.breakingbad.trial.base.BreakingBadApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton
/**
 * this interface is important for dagger application init
 *
 * */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class // Dagger class to add Base applications
])
interface AppComponent : AndroidInjector<BreakingBadApplication>{  // inject our base class
    override fun inject(application: BreakingBadApplication)
    /**
     * A builder for a component.
     * Components may have a single nested static abstract class or interface annotated with @Component.Builder.
     * If they do, then the component's generated builder will match the API in the type.
     * */
    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}