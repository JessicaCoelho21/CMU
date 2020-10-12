package pt.ipp.estg.firstApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mResultado;
    EditText mEditText;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultado = findViewById(R.id.textView3);
        mEditText = findViewById(R.id.editTextNumber3);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.valueOf(mEditText.getText().toString()) == 5){
                    mResultado.setText("O Resultado está correto!");
                } else {
                    mResultado.setText("O Resultado está errado!");
                }
            }
        });
    }
}