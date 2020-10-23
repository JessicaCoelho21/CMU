package pt.ipp.estg.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class RelativeLayout extends AppCompatActivity {
    Button tableButton;
    Spinner relativeSpinner;
    RadioButton relativeOpt1, relativeOpt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout);

        String[] arraySpinnner = new String[] {"Selecione o país...", "Portugal", "Espanha", "França",
                "Reino Unido", "Alemanha", "Itália"};

        tableButton = findViewById(R.id.button2);
        relativeSpinner = findViewById(R.id.spinner2);
        relativeOpt1 = findViewById(R.id.radioButton3);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnner);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        relativeSpinner.setAdapter(adapter);

        Intent i = new Intent(RelativeLayout.this, TableLayout.class);

        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }
}