package com.suraj.playo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.toast(text: String, duration:  Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}