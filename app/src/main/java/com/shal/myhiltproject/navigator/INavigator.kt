package com.shal.myhiltproject.navigator

enum class Screens {
    BUTTON,
    LOG
}

interface INavigator {
    fun navigationTo(screens: Screens);
}