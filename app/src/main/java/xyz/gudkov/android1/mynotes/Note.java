package xyz.gudkov.android1.mynotes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Note implements Parcelable {
    private int noteIndex;
    private String noteContent;

    public Note(int noteIndex, String noteContent) {
        this.noteIndex = noteIndex;
        this.noteContent = noteContent;
    }

    protected Note(Parcel in) {
        noteIndex = in.readInt();
        noteContent = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getNoteIndex());
        dest.writeString(getNoteContent());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getNoteIndex() {
        return noteIndex;
    }

    public String getNoteContent() {
        return noteContent;
    }
}
