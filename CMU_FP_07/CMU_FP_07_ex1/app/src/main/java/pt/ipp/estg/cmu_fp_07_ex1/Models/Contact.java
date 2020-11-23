package pt.ipp.estg.cmu_fp_07_ex1.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "Name")
    public String name;

    @ColumnInfo(name = "Number")
    public String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }
}

