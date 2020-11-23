package pt.ipp.estg.cmu_fp_07_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;

import pt.ipp.estg.cmu_fp_07_ex1.Models.Contact;

public class NewContact extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private EditText name;
    private EditText number;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact);

        name = findViewById(R.id.new_name);
        number = findViewById(R.id.new_phone);
        save = findViewById(R.id.save_button);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Add Contact");
        setSupportActionBar(toolbar);

        save.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        MainActivity.databaseWriteExecutor.execute(() -> {
            AppDatabase.getInstance(this).contactDAO().insert(new Contact(name.getText().toString(), number.getText().toString()));
        });
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