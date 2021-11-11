package com.suraj.playo.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.suraj.playo.ui.base.BaseActivity


inline fun <reified T: ViewModel>BaseActivity.getViewModel(): T {
    return ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
}