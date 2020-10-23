package pt.ipp.estg.cmu_fp_02_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mResultado;
    EditText mEditText;
    Button mButton;
    int i = 0;
    int[] answer = new int[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultado = findViewById(R.id.textView3);
        mEditText = findViewById(R.id.editTextNumber3);
        mButton = findViewById(R.id.button);

        for (i = 0; i < 10; i++) {
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Integer.valueOf(mEditText.getText().toString()) == 5) {
                        answer[i] = Integer.valueOf(mEditText.getText().toString());
                        mResultado.setText("O Resultado está correto!");
                    } else {
                        mResultado.setText("O Resultado está errado!");
                    }
                }
            });
        }

        //anotherActivity();
    }

    /*
    protected void anotherActivity() {
        Intent in = new Intent(MainActivity.this, NewActivity.class);
        in.putExtra("Text", (answer));
        startActivity(in);
    }
     */
}