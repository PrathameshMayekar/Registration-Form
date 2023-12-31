package com.example

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.sql.DriverManager.println
//import javax.naming.Context

class DBHelper(context: Context?) :

    SQLiteOpenHelper(context, DB_NAME, null, DB_VER) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        val query = "CREATE TABLE users(id VARCHAR(10) PRIMARY KEY, name TEXT, email TEXT, age INT)"
        sqLiteDatabase.execSQL(query)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users")
        onCreate(sqLiteDatabase)
    }

    fun registerUser(
        phonenumber: String?,
        firstname: String?,
        lastname: String?,
        housenumber: String?,
        city: String?,
        state: String?,
        pincode: String?,
        email: String?,
        manufacturer: String?,
        model: String?,
        year: String?
    ): Boolean {
        val sqLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        return try {
            contentValues.put("phonenumber", phonenumber)
            contentValues.put("firstname", firstname)
            contentValues.put("lastname", lastname)
            contentValues.put("housenumber", housenumber)
            contentValues.put("city", city)
            contentValues.put("state", state)
            contentValues.put("pincode", pincode)
            contentValues.put("email", email)
            contentValues.put("manufacturer", manufacturer)
            contentValues.put("model", model)
            contentValues.put("year", year)
            sqLiteDatabase.insert("users", null, contentValues)
            true
        } catch (e: Exception) {
            println(e.message)
            false
        } finally {
            sqLiteDatabase.close()
        }
    }

    companion object {
        private const val DB_NAME = "users"
        private const val DB_VER = 1
    }
}
