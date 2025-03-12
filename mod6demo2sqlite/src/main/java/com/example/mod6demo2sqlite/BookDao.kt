package com.example.mod6demo2sqlite

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class BookDao(
    private val dbW: SQLiteDatabase,
    private val dbR: SQLiteDatabase,
) {
    fun insertBook(book: Book): Boolean {

        val values = ContentValues().apply {
            put(BookContract.COLUMN_NAME, book.name);
            put(BookContract.COLUMN_ISBN, book.isbn);
            put(BookContract.COLUMN_RELEASE_DATE, book.releaseDate);
            put(BookContract.COLUMN_AUTHOR, book.author);
            put(BookContract.COLUMN_EDITOR, book.editor);
        }

        val newRowId = dbW.insert(BookContract.TABLE_NAME, null, values);

//        default val is 0 so we need 1 for id not 0 Long / first entry of table is at 0, so we don't want something under it
        return newRowId != -1L;

    }


    fun getAllBooks(): List<Book> {

        val projection = arrayOf(
            BaseColumns._ID,
            BookContract.COLUMN_NAME,
            BookContract.COLUMN_ISBN,
            BookContract.COLUMN_RELEASE_DATE,
            BookContract.COLUMN_AUTHOR,
            BookContract.COLUMN_EDITOR,
        );

        var cursor = dbR.query(
            BookContract.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            "${BookContract.COLUMN_NAME} DESC"
        );

        val books = mutableListOf<Book>();

        with(cursor){
            while (moveToNext()) {
                val book = Book(
                    id = getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    name = getString(getColumnIndexOrThrow(BookContract.COLUMN_NAME)),
                    isbn = getString(getColumnIndexOrThrow(BookContract.COLUMN_ISBN)),
                    releaseDate = getString(getColumnIndexOrThrow(BookContract.COLUMN_RELEASE_DATE)),
                    editor = getString(getColumnIndexOrThrow(BookContract.COLUMN_EDITOR)),
                    author = getString(getColumnIndexOrThrow(BookContract.COLUMN_AUTHOR))
                )
                books.add(book);
            }
        }
        cursor.close();

        return books;
    }
}