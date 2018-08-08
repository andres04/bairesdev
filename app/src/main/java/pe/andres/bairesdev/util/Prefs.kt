package pe.andres.bairesdev.util

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color

class Prefs (context: Context) {
    val PREFS_FILENAME = context.packageName +".prefs"
    val BACKGROUND_COLOR = "background_color"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

//    val favourites:

//    var bgColor: Int
//        get() = prefs.getInt(BACKGROUND_COLOR, Color.BLACK)
//        set(value) = prefs.edit().putInt(BACKGROUND_COLOR, value).apply()



}