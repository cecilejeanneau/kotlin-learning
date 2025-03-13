package com.example.mod6demo3room

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mod6demo3room.bo.Music
import com.example.mod6demo3room.room.AppDatabase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

// no use with front but use context and JUnit version
@RunWith(AndroidJUnit4::class)
class MusicDbTest {
    private lateinit var db : AppDatabase;

    @Before
    fun createDb(){
//        put it in memory
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build();
    }

    @After
    fun closeDb(){
        db.close();
    }

    @Test
    fun testInsertMusic() = runTest {
        val music = Music(
            0L,
            "Demain dès l'aube",
            "Les Frangines",
            220
        );
        val id = db.musicDAO().insert(music);

        assertTrue(id>0);
    }

    @Test
    fun testGetMusicById() = runTest {
//        unit test and first test is independent (because of close which delete test after) so need to insert something before to try to get it
        val music = Music(
            0L,
            "Demain dès l'aube",
            "Les Frangines",
            220
        );
        val id = db.musicDAO().insert(music);

        assertTrue(id>0);

        val foundMusic = db.musicDAO().findById(id);
        assertNotNull(foundMusic);
        assertNotNull(foundMusic.title);
        assertEquals(music.title, foundMusic.title);
        assertNotNull(foundMusic.author);
        assertEquals(music.author, foundMusic.author);
    }
}