package com.example.mod6demo2sqlite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListBookViewModel(
    dbHelper: BookDbHelper
) : ViewModel() {

//    DAO instance with read and write on DB
    private val dao = BookDao(dbHelper.writableDatabase, dbHelper.readableDatabase);

//    mutable var to create the list
    private val _books = MutableStateFlow<List<Book>>(emptyList());
    val books = _books.asStateFlow();

    init {
//    coroutine front which call coroutine for db
        viewModelScope.launch {
            insertBook(
                Book(
                    0L,
                    "L'écume des jours",
                    "35465435465465",
                    "09/02/1993",
                    "MOI",
                    "MOI"
                )
            );
            insertBook(
                Book(
                    1L,
                    "La mécanique du coeur",
                    "35465435465465465465",
                    "09/02/1993",
                    "MOI",
                    "MOI"
                ),
            );

            loadBooks();
        }

    }

//    suspend because async for call db
    suspend fun insertBook(book: Book) {
//        second coroutine (thread/process) to authorize entry/out of db
        withContext(Dispatchers.IO) {
            dao.insertBook(book);
        }
    }

    //    suspend because async for call db
    suspend fun loadBooks() {
//        second coroutine (thread/process) to authorize entry/out of db
        withContext(Dispatchers.IO) {
            val booksDB = dao.getAllBooks();
            if(booksDB != null) {
                _books.value = booksDB;
            }
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
                return ListBookViewModel(BookDbHelper(application.applicationContext)) as T
            }
        }
    }
}