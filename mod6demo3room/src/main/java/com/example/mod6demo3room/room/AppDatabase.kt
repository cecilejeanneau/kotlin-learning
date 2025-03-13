package com.example.mod6demo3room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mod6demo3room.bo.Music
import com.example.mod6demo3room.dao.MusicDAO

@Database(entities = [Music::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun musicDAO(): MusicDAO;

    //    singleton
    companion object {
        private var INSTANCE: AppDatabase? = null;

        fun getInstance(context: Context): AppDatabase {
            var instance = INSTANCE;

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "NotreMusique.db"
                ).fallbackToDestructiveMigration()
                    .build();
                INSTANCE = instance;
            }
            return instance;
        }
    }

}