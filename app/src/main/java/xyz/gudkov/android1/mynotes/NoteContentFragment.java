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

    public static final  String ARG_INDEX = "index";
    private int index;

    public static NoteContentFragment newInstance (int index) {
        NoteContentFragment n = new NoteContentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX,index);
        n.setArguments(args);
        return n;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.fragment_note_content, container,false);
        TextView textNote = view.findViewById(R.id.contentNote);
        TypedArray noteContentArray = getResources().obtainTypedArray(R.array.noteContent);

        textNote.setText(noteContentArray.getText(index));
        return view;
    }
}