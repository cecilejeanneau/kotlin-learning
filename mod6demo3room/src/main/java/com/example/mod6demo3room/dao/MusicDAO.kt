package com.example.mod6demo3room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mod6demo3room.bo.Music

@Dao
interface MusicDAO {

    @Insert
    suspend fun insert (music: Music): Long;

    @Query("SELECT * FROM music")
    fun findAll(): List<Music>

//    tested on unit test
    @Query("SELECT * FROM Music WHERE id = :id")
    fun findById(id: Long): Music
}