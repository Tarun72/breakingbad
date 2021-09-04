package com.breakingbad.trial.base

import android.os.Bundle
import dagger.android.DaggerActivity

abstract class BaseActivity : DaggerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}