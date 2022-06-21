package coderpie.NoteMe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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



            bindingMain.recyclerViewMain.adapter = NoteAdapter(title, text)

        bindingMain.floatingActionButton.setOnClickListener {
            val intentActivity_Edit_Entry = Intent(this, Edit_Entry_Activity::class.java).also {
                startActivity(it)
            }
        }









    }
}