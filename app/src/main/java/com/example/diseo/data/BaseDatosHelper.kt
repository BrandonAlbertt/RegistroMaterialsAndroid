package com.example.diseo.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatosHelper(context: Context) : SQLiteOpenHelper(context, "colegio_kvbe.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
                CREATE TABLE IF NOT EXISTS Docente (
                    idB INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombreB TEXT NOT NULL,
                    paternoB TEXT NOT NULL,
                    maternoB TEXT NOT NULL,
                    generoB TEXT NOT NULL,
                    sueldoB REAL NOT NULL,
                    hijosB INTEGER NOT NULL
                )
            """.trimIndent()
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Docente")
        onCreate(db)
    }
}
