package pt.ipp.estg.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    String mResultado;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newactivity);

        resultado = findViewById(R.id.textView);
        mResultado = getIntent().getStringExtra("Text");

        if(mResultado != null)
            resultado.setText(mResultado);
        else
            resultado.setText("Something went wrong...");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}