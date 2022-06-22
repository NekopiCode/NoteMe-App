package coderpie.NoteMe

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coderpie.NoteMe.databinding.ActivityEditEntryBinding



class Edit_Entry_Activity : AppCompatActivity() {
    private val databaseHelper = NoteDatabaseHelper(this)
    private lateinit var bindingSecond: ActivityEditEntryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSecond = ActivityEditEntryBinding.inflate(layoutInflater)
        setContentView(bindingSecond.root)




        bindingSecond.floatingActionButton2.setOnClickListener {
            val inputTitle = bindingSecond.etTitle.text.toString()
            val inputText = bindingSecond.etText.text.toString()


            val helper = databaseHelper
            helper.insertNoteTableDB(inputTitle, inputText)
            databaseHelper.close()

            val intentActivity_Edit_Entry = Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }

        }
    }
}