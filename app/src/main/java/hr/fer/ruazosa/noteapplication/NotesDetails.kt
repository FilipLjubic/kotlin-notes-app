package hr.fer.ruazosa.noteapplication

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notes_details.*
import java.util.*

class NotesDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_details)

        val viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
                NotesViewModel::class.java)

        saveNoteButton.setOnClickListener {
            var note = Note()
            note.noteTitle = noteTitleEditText.text.toString()
            note.noteDescription = noteDescriptionEditText.text.toString()
            note.noteDate = Date()
            viewModel.saveNoteToRepository(note)
            finish()
        }
    }


}
