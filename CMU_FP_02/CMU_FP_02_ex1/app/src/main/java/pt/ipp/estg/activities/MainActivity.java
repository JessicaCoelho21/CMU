package pt.ipp.estg.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.button4);

        Intent i = new Intent(MainActivity.this, NewActivity.class);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Texto escrito: " + mEditText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("Text", (mEditText.getText().toString()));
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}