package br.com.smk.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.smk.notes.entities.Note
import kotlinx.android.synthetic.main.row_note.view.*

class NoteListAdapter(
    private val context: Context,
    private val listNotes: List<Note>
): RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = listNotes[position]

        holder.bindNote(note)
    }

    override fun getItemCount(): Int {
        return listNotes.size
    }

    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title = itemView.textview_note_title
        val description = itemView.textview_note_description

        fun bindNote(note: Note) {
            title.text = note.title
            description.text = note.description
        }
    }
}

