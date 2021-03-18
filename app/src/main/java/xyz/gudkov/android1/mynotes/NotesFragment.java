package xyz.gudkov.android1.mynotes;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NotesFragment extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }
    @Override
    public void onViewCreated (@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout)view;
        String[] notes = getResources().getStringArray(R.array.notes);
        for (int i = 0; i < notes.length ; i++) {
            String note = notes[i];
            TextView tv = new TextView(getContext());
            tv.setText(note);
            tv.setTextSize(30);
            layoutView.addView(tv);
            final  int fi = i;
            tv.setOnClickListener(v -> showNoteContent(fi));
        }
    }

    private void showNoteContent(int index) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), NoteContentActivity.class);
        intent.putExtra(NoteContentFragment.ARG_INDEX, index);
        startActivity(intent);
    }
}

