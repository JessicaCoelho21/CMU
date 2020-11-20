package pt.ipp.estg.toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import pt.ipp.estg.toolbar.Models.Contact;

public class ContactDetails extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        textView = findViewById(R.id.text_view);

        Contact contact = (Contact) getIntent().getSerializableExtra("CONTACT");
        textView.setText(contact.getName());
    }
}