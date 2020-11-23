package pt.ipp.estg.cmu_fp_07_ex1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import pt.ipp.estg.cmu_fp_07_ex1.Interfaces.ContactDAO;
import pt.ipp.estg.cmu_fp_07_ex1.Models.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDAO contactDAO();
    private static AppDatabase INSTANCE;
    private static final Object sLock = new Object();

    //Migration
    public static AppDatabase getInstance(Context context) {
        synchronized (sLock){
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "contact.db").build();
            }

            return INSTANCE;
        }
    }
}
