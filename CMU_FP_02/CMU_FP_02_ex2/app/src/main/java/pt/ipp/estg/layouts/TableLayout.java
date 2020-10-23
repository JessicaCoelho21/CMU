package pt.ipp.estg.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class TableLayout extends AppCompatActivity {
    Button finishButton;
    Spinner tableSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        String[] arraySpinnner = new String[] {"Selecione o país...", "Portugal", "Espanha", "França",
                "Reino Unido", "Alemanha", "Itália"};

        finishButton = findViewById(R.id.button3);
        tableSpinner = findViewById(R.id.spinner3);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnner);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tableSpinner.setAdapter(adapter);

        Intent i = new Intent(TableLayout.this, LinearLayout.class);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Volta à RelativeActivity
                finish();
                System.exit(0);

                //Volta à LinearActivity
                //startActivity(i);
            }
        });
    }
}