package pt.ipp.estg.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pt.ipp.estg.recyclerview.adapters.ContactAdapter;
import pt.ipp.estg.recyclerview.models.Contacts;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ContactAdapter mAdapter;
    private static int lastContactId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create contact list
        List<Contacts> contacts = createContactsList(200);

        //Create contacts adapter
        mAdapter = new ContactAdapter(this, contacts);

        //Set RecycleView adapter
        mRecyclerView = findViewById(R.id.recycle);
        mRecyclerView.setAdapter(mAdapter);

        //Set LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Divide RecycleView elements with a gray line
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    public ArrayList<Contacts> createContactsList(int numContacts) {
        ArrayList<Contacts> contacts = new ArrayList<Contacts>();
        Random r = new Random();

        for (int i = 0; i <= numContacts; i++) {
            contacts.add(new Contacts("Person" + ++lastContactId, r.nextBoolean()));
        }

        return contacts;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MAIN_ACTIVITY", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
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
