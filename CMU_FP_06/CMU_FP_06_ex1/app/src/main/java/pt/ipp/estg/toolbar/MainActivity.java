package pt.ipp.estg.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pt.ipp.estg.toolbar.Adapters.ContactAdapter;
import pt.ipp.estg.toolbar.Models.Contact;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContactAdapter adapter;
    private Toolbar toolbar;
    private View root;

    private static int lastContactId = 0;

    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Preferences
        settings = PreferenceManager.getDefaultSharedPreferences(this);

        //Create contact list
        List<Contact> contacts = createContactsList(200);

        //Create contacts adapter
        adapter = new ContactAdapter(this, contacts);

        //Set RecyclerView adapter
        recyclerView = findViewById(R.id.recycler_view);
        root = recyclerView.getRootView();
        recyclerView.setAdapter(adapter);

        //Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Divide RecycleView elements with a gray line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //Set Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Contact's List");
        setSupportActionBar(toolbar);
    }

    public ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        Random r = new Random();

        for (int i = 0; i <= numContacts; i++) {
            contacts.add(new Contact("Person" + ++lastContactId, r.nextBoolean()));
        }

        return contacts;
    }

    private void changeBackground(String color) {
        if (color.equals("WHITE")) {
            root.setBackgroundColor(Color.WHITE);
        } else if (color.equals("YELLOW")) {
            root.setBackgroundColor(Color.YELLOW);
        } else if (color.equals("RED")) {
            root.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                this.startActivity(i);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MAIN_ACTIVITY", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        String color = settings.getString("COLOR", "WHITE");
        changeBackground(color);

        Log.d("MAIN_ACTIVITY", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MAIN_ACTIVITY", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MAIN_ACTIVITY", "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MAIN_ACTIVITY", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MAIN_ACTIVITY", "onDestroy()");
    }
}