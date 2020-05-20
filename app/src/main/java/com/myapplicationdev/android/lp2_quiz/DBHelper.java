package com.myapplicationdev.android.lp2_quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    //TODO Define the Database properties
    private static final String DATABASE_NAME = "mydb.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_TODO = "todo";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_DATA = "data";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO CREATE TABLE Note
        String createNoteTableSql = "CREATE TABLE " + TABLE_TODO + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATE + " TEXT, " + COLUMN_DATA + " TEXT)";
        db.execSQL(createNoteTableSql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(db);
    }

    public void insertToDo(String data, String date) {
        //TODO insert the data into the database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_DATA, data);
        values.put(COLUMN_DATE, date);

        db.insert(TABLE_TODO, null, values);
        db.close();
    }

    public ArrayList<ToDo> getToDo() {
        //TODO return records in Java objects
        ArrayList<ToDo> notes = new ArrayList<ToDo>();
        String selectQuery = "SELECT " + COLUMN_ID + "," +
                COLUMN_DATE + "," + COLUMN_DATA+ " FROM "
                + TABLE_TODO;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String date = cursor.getString(1);
                String data = cursor.getString(2);

                ToDo todo = new ToDo(id, date, data);
                notes.add(todo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return notes;
    }

    public ArrayList<String> getNoteContent() {
        //TODO return records in Strings

        ArrayList<String> todos = new ArrayList<String>();
        String selectQuery = "SELECT note_content from todo";


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String Date = cursor.getString(1);
                String Data = cursor.getString(2);
                todos.add(cursor.getString(0));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return todos;
    }
}

