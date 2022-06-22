package coderpie.NoteMe

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.recyclerview.widget.LinearLayoutManager
import coderpie.NoteMe.databinding.ActivityEntryBinding
import coderpie.NoteMe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMain: ActivityMainBinding
    private var title = arrayListOf("")
    private var text = arrayListOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)
        bindingMain.recyclerViewMain.layoutManager = LinearLayoutManager(this)

        val textExample = listOf(
            "Wenn du heute das Gestern nicht verarbeitet hast, kannst du auch das Morgen nicht planen.",
            "Zutrittsverbot für blockierende Gedanken, die Stau verursachen, unnötig Ärger und Stress machen.",
            "Familienzwist und Ehestreit sind verschenkte Lebenszeit.")

           for (i in 1..20)
               title.add("Title Test Nr.: $i")

           for (i in 1..20)
               text.add(textExample.random())

            //bindingMain.recyclerViewMain.adapter = NoteAdapter(title, text)

        val db = NoteDatabaseHelper(this)
        bindingMain.recyclerViewMain.adapter = db.getTitle()?.let { NoteAdapter(it, db.getText()!!) }

        bindingMain.floatingActionButton.setOnClickListener {
            val intentActivity_Edit_Entry = Intent(this, Edit_Entry_Activity::class.java).also {
                startActivity(it)
            }
        }











    }
}