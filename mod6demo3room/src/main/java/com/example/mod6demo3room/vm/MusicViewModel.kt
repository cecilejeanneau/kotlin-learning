package com.example.mod6demo3room.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod6demo3room.bo.Music
import com.example.mod6demo3room.dao.MusicDAO
import com.example.mod6demo3room.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MusicViewModel(
    private val musicDAO: MusicDAO
): ViewModel() {

    private val _musics = MutableStateFlow<List<Music>>(emptyList());
    val musics: Flow<List<Music>> = _musics;

    init {
        viewModelScope.launch {
            insertMusic(
                Music(
//                    0L doesn't exist, so it consider by default that it's needed to create an other auto id
                    0L,
                    "Warrior",
                    "Aurora",
                    220
                )
            );
            insertMusic(
                Music(
                    0L,
                    "Demain dès l'aube",
                    "Les Frangines",
                    220
                )
            );
            loadMusics();
        }
    }

    private suspend fun loadMusics() {
        withContext(Dispatchers.IO){
            _musics.value = musicDAO.findAll();
        }
    }

    private suspend fun insertMusic(music: Music){
        withContext(Dispatchers.IO){
            musicDAO.insert(music);
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create (
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY]);
                return MusicViewModel(
                    AppDatabase
                        .getInstance(application.applicationContext)
                        .musicDAO()
                ) as T
            }
        }
    }
}