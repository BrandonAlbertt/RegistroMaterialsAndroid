package com.example.diseo.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.diseo.data.BaseDatosHelper
import com.example.diseo.entidad.Docente

class DocenteDao(context: Context) {
    private val dbHelper = BaseDatosHelper(context)

    // Insertar un docente
    fun insertar(docente: Docente): Long {
        val db = dbHelper.writableDatabase
        return try {
            val values = ContentValues().apply {
                put("nombreB", docente.nombreE)
                put("paternoB", docente.paternoE)
                put("maternoB", docente.maternoE)
                put("generoB", docente.generoE)
                put("sueldoB", docente.sueldoE)
                put("hijosB", docente.hijosE)
            }
            db.insert("Docente", null, values)
        } catch (e: Exception) {
            e.printStackTrace()
            -1L
        } finally {
            db.close()
        }
    }

    // Listar todos los docentes
    fun listarDocentes(): List<Docente> {
        val lista = mutableListOf<Docente>()
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM Docente", null)

        while (cursor.moveToNext()) {
            val docente = Docente().apply {
                idE = cursor.getInt(cursor.getColumnIndexOrThrow("idB"))
                nombreE = cursor.getString(cursor.getColumnIndexOrThrow("nombreB"))
                paternoE = cursor.getString(cursor.getColumnIndexOrThrow("paternoB"))
                maternoE = cursor.getString(cursor.getColumnIndexOrThrow("maternoB"))
                generoE = cursor.getString(cursor.getColumnIndexOrThrow("generoB"))
                sueldoE = cursor.getDouble(cursor.getColumnIndexOrThrow("sueldoB"))
                hijosE = cursor.getInt(cursor.getColumnIndexOrThrow("hijosB"))
            }
            lista.add(docente)
        }

        cursor.close()
        return lista
    }
    /*
        // Editar (Actualizar) un docente
        fun editar(docente: Docente): Int {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put("nombreB", docente.nombreE)
                put("paternoB", docente.paternoE)
                put("maternoB", docente.maternoE)
                put("generoB", docente.generoE)
                put("sueldoB", docente.sueldoE)
                put("hijosB", docente.hijosE)
            }
            // WHERE idB = ?  => arrayOf(docente.idE.toString())
            return db.update("Docente", values, "idB = ?", arrayOf(docente.idE.toString()))
        }

        // Eliminar un docente por su ID
        fun eliminar(id: Int): Int {
            val db = dbHelper.writableDatabase
            return db.delete("Docente", "idB = ?", arrayOf(id.toString()))
        }
        *?
         */

}
