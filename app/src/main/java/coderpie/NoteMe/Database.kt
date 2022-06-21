package coderpie.NoteMe

import android.content.ContentValues
import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class NoteDatabaseHelper(context: Context) : SQLiteOpenHelper (context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object Contract {
        const val DATABASE_NAME = "NoteDatabase"
        const val DATABASE_VERSION = 1

        object NoteTableDB {
            const val TABLE_NAME = "Note"
            const val COLUMN_ID = "id"
            const val COLUMN_NOTE_TITEL = "note_title"
            const val COLUMN_NOTE_TEXT = "note_text"
        }

        const val SQL_CREATE_NOTE_TABLE = "CREATE TABLE ${NoteTableDB.TABLE_NAME} (" +
                "${NoteTableDB.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "${NoteTableDB.COLUMN_NOTE_TITEL} TEXT NOT NULL, " +
                "${NoteTableDB.COLUMN_NOTE_TEXT} TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_NOTE_TABLE)
        Log.i(javaClass.simpleName, "Database is created in \"" + db?.getPath() + "\"")
    }

    override fun onUpgrade(db: SQLiteDatabase?, OldVersion: Int, newVersion: Int) {
    }

    fun insertNoteTableDB(noteTitle: String, noteText: String){
        val values = ContentValues(2)
        with(values) {
            put(NoteDatabaseHelper.Contract.NoteTableDB.COLUMN_NOTE_TITEL, noteTitle)
            put(NoteDatabaseHelper.Contract.NoteTableDB.COLUMN_NOTE_TEXT, noteText)
        }
        val db = writableDatabase
        try {
            db.insertOrThrow(NoteDatabaseHelper.Contract.NoteTableDB.TABLE_NAME, null, values)
        } catch (ex: SQLException) {
            Log.d(javaClass.simpleName, ex.toString())
        } finally {
            db.close()
        }
    }
}
