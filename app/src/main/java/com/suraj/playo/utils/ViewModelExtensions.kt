package com.suraj.playo

import androidx.lifecycle.ViewModel


inline fun <reified T: ViewModel> BaseActivity.getViewModel(): T {
    return ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
}