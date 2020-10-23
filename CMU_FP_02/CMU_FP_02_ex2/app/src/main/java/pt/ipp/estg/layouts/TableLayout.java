package pt.ipp.estg.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class TableLayout extends AppCompatActivity {
    Button finishButton;
    Spinner tableSpinner;
    RadioButton tableOpt1, tableOpt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        String[] arraySpinnner = new String[] {"Selecione o país...", "Portugal", "Espanha", "França",
                "Reino Unido", "Alemanha", "Itália"};

        finishButton = findViewById(R.id.button3);
        tableSpinner = findViewById(R.id.spinner3);
        tableOpt1 = findViewById(R.id.radioButton5);
        tableOpt2 = findViewById(R.id.radioButton6);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnner);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tableSpinner.setAdapter(adapter);

        Intent i = new Intent(TableLayout.this, LinearLayout.class);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = tableSpinner.getSelectedItem().toString();

                if(country != "Selecione o país..." && (tableOpt1.isChecked() || tableOpt2.isChecked())){
                    /*
                    Volta à LinearActivity
                    startActivity(i);
                    */

                    //Volta à RelativeActivity
                    finish();
                    System.exit(0);
                } else{
                    Toast.makeText(TableLayout.this, "Por favor, introduza todos os campos!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}