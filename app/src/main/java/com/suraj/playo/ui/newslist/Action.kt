package com.suraj.playo.ui.newslist

import com.ww.roxie.BaseAction

sealed class Action : BaseAction {

    object LoadNews : Action() {
             override fun toString() = obfuscatedString()
        }
}
