package xyz.gudkov.android1.mynotes;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class NoteContentFragment extends Fragment {

    public static final  String ARG_NOTE = "note";
    private Note note;

    public static NoteContentFragment newInstance (Note note) {
        NoteContentFragment n = new NoteContentFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE,note);
        n.setArguments(args);
        return n;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getParcelable(ARG_NOTE);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_content, container,false);
        TextView textNote = view.findViewById(R.id.contentNote);
        TypedArray noteContentArray = getResources().obtainTypedArray(R.array.noteContent);
        TypedArray noteNameArray = getResources().obtainTypedArray(R.array.notes);

        TextView noteNameView = view.findViewById(R.id.noteName);
        noteNameView.setText(noteNameArray.getText(note.getNoteIndex()));
        textNote.setText(noteContentArray.getText(note.getNoteIndex()));
        return view;
    }
}