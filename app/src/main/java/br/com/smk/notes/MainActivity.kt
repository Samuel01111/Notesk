package br.com.smk.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.smk.notes.databinding.ActivityMainBinding
import br.com.smk.notes.entities.Note
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(null)
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        val recyclerViewNote = binding.recyclerViewNoteList
        recyclerViewNote.adapter = NoteListAdapter(this, getNoteList())
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerViewNote.layoutManager = layoutManager

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun getNoteList(): List<Note> {
        var noteList: MutableList<Note> = mutableListOf()

        var i = 1
        while (i < 200) {
            noteList.add(
                Note(
                    title = "Title",
                    subtitle = "subtitle",
                    description = "description",
                    null,
                    null
                )
            )
            i += 1
        }

        return noteList
    }
}
