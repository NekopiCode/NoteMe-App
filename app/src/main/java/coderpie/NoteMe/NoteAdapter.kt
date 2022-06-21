package coderpie.NoteMe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coderpie.NoteMe.databinding.ActivityEntryBinding

class NoteAdapter(private val title: ArrayList<String>, private val text: ArrayList<String>) : RecyclerView.Adapter<EntryHolder>() {
    override fun getItemCount(): Int {
        return title.size; text.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryHolder {
        val unfold = LayoutInflater.from(parent.context)
        val bindingEntry = ActivityEntryBinding.inflate(unfold, parent, false)
        return EntryHolder(bindingEntry)
    }

    override fun onBindViewHolder(entryObject: EntryHolder, index: Int) {
        entryObject.bindingEntry.textViewTitle.text = title[index]
        entryObject.bindingEntry.textViewText.text = text[index]
    }
}