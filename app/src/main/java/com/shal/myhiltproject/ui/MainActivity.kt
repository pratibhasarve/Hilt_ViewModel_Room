package com.shal.myhiltproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.shal.myhiltproject.MyApplication
import com.shal.myhiltproject.R
import com.shal.myhiltproject.navigator.INavigator
import com.shal.myhiltproject.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: INavigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.navigationTo(Screens.BUTTON)
    }
}