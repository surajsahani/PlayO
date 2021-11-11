package com.shopgraam.playo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders


inline fun <reified T: ViewModel> BaseActivity.getViewModel(): T {
    return ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
}