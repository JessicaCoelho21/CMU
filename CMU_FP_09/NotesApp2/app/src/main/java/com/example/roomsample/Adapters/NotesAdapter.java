package com.example.roomsample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.roomsample.Database.NotesDatabase;
import com.example.roomsample.R;
import com.example.roomsample.model.Note;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private Context mContext;
    private List<Note> mNotes;
    private final NotesDatabase mNotesDb;

    public NotesAdapter(Context context, List<Note> notes, NotesDatabase notesDb) {
        mContext = context;
        this.mNotesDb = notesDb;
        this.mNotes = notes;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.note_row, parent, false);
        return new NoteViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder viewHolder, int position) {
        Note note = mNotes.get(position);
        viewHolder.titleTextView.setText(note.title);
        viewHolder.descriptionTextView.setText(note.description);
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public TextView descriptionTextView;
        public Button doneButton;

        public NoteViewHolder(View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.title);
            descriptionTextView = itemView.findViewById(R.id.description);
            doneButton = itemView.findViewById(R.id.button);
            doneButton.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {

                    int pos = getAdapterPosition();
                    final Note note = mNotes.remove(pos);
                    NotesDatabase.databaseWriteExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            mNotesDb.getNotesDao().deleteNote(note);
                        }
                    });
                    notifyItemRemoved(pos);
                }
            });


        }
    }
}
