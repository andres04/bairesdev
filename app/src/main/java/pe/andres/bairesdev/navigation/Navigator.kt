package pe.andres.bairesdev.navigation

import android.content.Context
import android.content.Intent

import pe.andres.bairesdev.ui.home.HomeActivity

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Provides methods to navigate to the different activities in the application.
 */
@Singleton
class Navigator @Inject
internal constructor() {

    fun toHome(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
    }
}
