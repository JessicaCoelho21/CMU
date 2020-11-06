package pt.ipp.estg.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

import pt.ipp.estg.recyclerview.models.Contacts;

public class ContactDetails extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        textView = findViewById(R.id.textView);
        Contacts contacts = (Contacts) getIntent().getSerializableExtra("Contact");

        textView.setText(contacts.getmName());
    }
}