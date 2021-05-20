package com.shal.myhiltproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.shal.myhiltproject.R
import com.shal.myhiltproject.db.Note
import com.shal.myhiltproject.navigator.INavigator
import com.shal.myhiltproject.navigator.Screens
import com.shal.myhiltproject.view_model.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ButtonFragment : Fragment() {

    @Inject
    lateinit var navigator: INavigator

    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val editNote = view.findViewById<EditText>(R.id.edit_note)
        val btnButton2 = view.findViewById<Button>(R.id.btn_add_notes)
        btnButton2.setOnClickListener {

            if (!editNote.text.isEmpty()) {
                var note = Note(0, editNote.text.toString())
                noteViewModel.insertNote(note)
                editNote.text.clear()
            }else{
                Toast.makeText(requireActivity(), getString(R.string.write_some_note), Toast.LENGTH_SHORT).show()
            }
        }

        val btnAllLogs = view.findViewById<Button>(R.id.btn_get_notes)
        btnAllLogs.setOnClickListener {
            navigator.navigationTo(Screens.LOG)
        }

        val btnDeleteLogs = view.findViewById<Button>(R.id.btn_delete_notes)
        btnDeleteLogs.setOnClickListener {
            noteViewModel.deleteNote()
        }
    }

}