package pt.ipp.estg.cmu_fp_07_ex1.Interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import pt.ipp.estg.cmu_fp_07_ex1.Models.Contact;

@Dao
public interface ContactDAO {
    @Query("SELECT * FROM contact")
    public List<Contact> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Contact contact);

    @Delete
    public void delete(Contact contact);
}
