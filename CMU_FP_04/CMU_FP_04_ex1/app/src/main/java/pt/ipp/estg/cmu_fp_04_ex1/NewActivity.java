package pt.ipp.estg.cmu_fp_04_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    TextView result;
    String spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        result = findViewById(R.id.textView);
        spinner = getIntent().getStringExtra("Option");

        result.setText(spinner);
    }
}