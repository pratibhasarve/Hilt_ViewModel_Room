package com.shal.myhiltproject.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shal.myhiltproject.R
import com.shal.myhiltproject.db.Note

class NoteListAdapter() :
    RecyclerView.Adapter<NoteListAdapter.NoteVieHolder>() {

    private var dataSet: List<Note> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVieHolder {
        return NoteVieHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NoteVieHolder, position: Int) {
        val current = dataSet[position]
        holder.bind(current.note)
    }

    class NoteVieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val note: TextView = itemView.findViewById(R.id.txt_note)
        fun bind(text: String?) {
            note.text = text
        }

        companion object {
            fun create(parent: ViewGroup): NoteVieHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.note_row_item, parent, false)
                return NoteVieHolder(view)
            }
        }
    }

    override fun getItemCount() = dataSet.size

    fun submitList(list: List<Note>) {
        this.dataSet = list
        notifyDataSetChanged()
    }

}

