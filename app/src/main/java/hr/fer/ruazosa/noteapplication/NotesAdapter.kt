package hr.fer.ruazosa.noteapplication
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NotesAdapter(listOfNotesViewModel: NotesViewModel): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    var listOfNotes: NotesViewModel = listOfNotesViewModel

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var noteTitleTextView: TextView? = null
        var noteDateTextView: TextView? = null
        init {
            noteTitleTextView = itemView.findViewById(R.id.noteTitleTextView)
            noteDateTextView = itemView.findViewById(R.id.noteDateTextView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NotesAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val notesListElement = inflater.inflate(R.layout.note_list_element, parent, false)
        return ViewHolder(notesListElement)
    }

    override fun getItemCount(): Int {
        if (listOfNotes.notesList.value != null) {
            return listOfNotes.notesList.value!!.count()
        }
        return 0
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if (listOfNotes != null) {
            viewHolder.noteTitleTextView?.text = listOfNotes.notesList.value!![position].noteTitle


            viewHolder.noteDateTextView?.text =
                listOfNotes.notesList.value!![position].noteDate.toString()
        }
    }
}