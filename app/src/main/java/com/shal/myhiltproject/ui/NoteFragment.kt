package com.shal.myhiltproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shal.myhiltproject.R
import com.shal.myhiltproject.db.Note
import com.shal.myhiltproject.view_model.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : Fragment() {

    private val noteViewModel: NoteViewModel by viewModels()

    private var listNotes: List<Note> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteRecycler = view.findViewById<RecyclerView>(R.id.note_recycler_view)
        val adapter = NoteListAdapter()
        noteRecycler.adapter = adapter
        noteRecycler.layoutManager = LinearLayoutManager(requireContext())

        noteViewModel.allNotes.observe(requireActivity(), Observer { notes ->
            // Update the cached copy of the words in the adapter.
            notes?.let {
                  adapter.submitList(it)
            }
        })
    }
}