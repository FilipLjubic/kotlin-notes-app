package hr.fer.ruazosa.noteapplication

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class NotesViewModel: ViewModel() {
    var notesList = MutableLiveData<List<Note>>()

    fun getNotesRepository() {
        notesList.value = NotesRepository.notesList
    }

    fun saveNoteToRepository(note: Note) {
        NotesRepository.notesList.add(note)
    }
}