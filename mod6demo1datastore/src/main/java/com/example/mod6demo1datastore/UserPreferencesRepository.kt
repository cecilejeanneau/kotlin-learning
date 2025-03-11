package com.example.mod6demo1datastore

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(
    private val context: Context
) {

    private val Context.datastore by preferencesDataStore(name = "user_preference");

    private val KEY_BG_COLOR_SELECTED = intPreferencesKey("KEY_BG_COLOR_SELECTED");

//    save a data in store
    suspend fun saveBgColor(color: Color){
        context.datastore.edit { pref ->
            pref[KEY_BG_COLOR_SELECTED] = color.toArgb();
        }
    }

//    load a color
suspend fun getBgColor(): Flow<Color> {
    return context.datastore.data.map { pref ->
        Color(pref[KEY_BG_COLOR_SELECTED]?:Color.White.toArgb());
    }
}
}
