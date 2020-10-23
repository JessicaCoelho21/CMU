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

public class LinearLayout extends AppCompatActivity {
    Button relativeButton;
    Spinner linearSpinner;
    RadioButton linearOpt1, linearOpt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        String[] arraySpinnner = new String[] {"Selecione o país...", "Portugal", "Espanha", "França",
                "Reino Unido", "Alemanha", "Itália"};

        relativeButton = findViewById(R.id.button);
        linearSpinner = findViewById(R.id.spinner);
        linearOpt1 = findViewById(R.id.radioButton);
        linearOpt2 = findViewById(R.id.radioButton2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinnner);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        linearSpinner.setAdapter(adapter);

        Intent i = new Intent(LinearLayout.this, RelativeLayout.class);

        relativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = linearSpinner.getSelectedItem().toString();

                if(country != "Selecione o país..." && (linearOpt1.isChecked() || linearOpt2.isChecked())){
                    startActivity(i);
                } else{
                    Toast.makeText(LinearLayout.this, "Por favor, introduza todos os campos!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}