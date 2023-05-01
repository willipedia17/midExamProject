package com.example.midexamproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String databaseName = "Signup.db";

    public DBHelper(@Nullable Context context) {
        super(context, "Signup.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (userId integer primary key AUTOINCREMENT, fullName TEXT, phoneNumber TEXT, email TEXT, password TEXT)");
//        db.execSQL("Create table transactions (transactionId integer primary key AUTOINCREMENT, matchId TEXT, amountTicket integer, totalPrice integer, foreign  key(usersId) REFERENCES users(usersId))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
//        db.execSQL("drop table if exists transactions");
    }

    public void insertUsers(String fullName, String phone, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("fullName", fullName);
        values.put("phoneNumber", phone);
        values.put("email", email);
        values.put("password", password);

        db.insert("users", null, values);
        db.close();
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = ?", new String[]{email});

        if(cursor.getCount() > 0){
            return true;
        } else return false;
    }


    public Boolean checkEmailPass(String email, String password){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = ? and password = ?", new String[]{email, password});

        if(cursor.getCount() > 0){
            return true;
        } else return false;
    }

    public void insertTransaction(int matchId, int amountTicket,int totalPrice){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("match id", matchId);
        values.put("amount", amountTicket);
        values.put("total price", totalPrice);

        db.insert("transactions", null, values);
        db.close();
    }
}
