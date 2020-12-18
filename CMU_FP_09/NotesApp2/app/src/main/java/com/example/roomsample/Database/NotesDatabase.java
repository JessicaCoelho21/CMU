package com.example.roomsample.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomsample.model.Note;
import com.example.roomsample.model.NoteDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Note.class}, version = 1)
public abstract class NotesDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS=4;
    private static volatile NotesDatabase INSTANCE;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
//
    public static NotesDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NotesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NotesDatabase.class, "notes_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public abstract NoteDao getNotesDao();
}
