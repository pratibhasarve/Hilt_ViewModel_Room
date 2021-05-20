package com.shal.myhiltproject.navigator
import androidx.fragment.app.FragmentActivity
import com.shal.myhiltproject.R
import com.shal.myhiltproject.ui.ButtonFragment
import com.shal.myhiltproject.ui.NoteFragment
import javax.inject.Inject

class NavigationImpl @Inject constructor(private val activity: FragmentActivity) : INavigator {

    override fun navigationTo(screens: Screens) {

        var fragment = when (screens) {
            Screens.BUTTON -> ButtonFragment()
            Screens.LOG -> NoteFragment()
        }

        activity.supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment)
            .addToBackStack(fragment::class.java.canonicalName).commit()
    }

}