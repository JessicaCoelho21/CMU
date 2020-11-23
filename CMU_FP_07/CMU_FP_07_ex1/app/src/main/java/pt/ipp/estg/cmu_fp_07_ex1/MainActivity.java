package pt.ipp.estg.cmu_fp_07_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pt.ipp.estg.cmu_fp_07_ex1.Adapter.ContactAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private ContactAdapter adapter;

    public static final int NUMBER_OF_THREADS = 2;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    AppDatabase sampleDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //Build database
        sampleDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "contact.db").build();

        //Set Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Contact's List");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_contact:
                Intent i = new Intent(MainActivity.this, NewContact.class);
                this.startActivity(i);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MAIN_ACTIVITY", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Create contacts adapter
        adapter = new ContactAdapter(this);

        //Set Recycler View adapter
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);

        //Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Divide RecycleView elements with a gray line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

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