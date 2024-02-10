package edu.utem.ftmk.projectnative.sqliteDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;

import edu.utem.ftmk.projectnative.Domain.User;

public class DatabaseUser extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_db";
    private static final int DATABASE_VERSION = 1;

    // User table creation query
    private static final String CREATE_TABLE_USERS = "CREATE TABLE users " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "username TEXT, " +
            "password TEXT);";

    public DatabaseUser(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public long addUser(User user) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user.getUsername());
        values.put("password", user.getPassword());

        return database.insert("users", null, values);
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase database = this.getWritableDatabase();
        String[] columns = {"id"};
        String selection = "username=? AND password=?";
        String[] selectionArgs = {username, password};

        Cursor cursor = database.query("users", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        database.close();

        return count > 0;
    }
}

