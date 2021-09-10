package com.breakingbad.trial.characters.di

import javax.inject.Scope

/**
 * AuthScope is strictly for login and registration
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class CharacterScope