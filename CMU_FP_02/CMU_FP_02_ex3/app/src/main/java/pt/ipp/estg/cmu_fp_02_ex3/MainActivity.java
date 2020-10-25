package pt.ipp.estg.cmu_fp_02_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEditText;
    private Button mButton;
    private TextView mQuestion;
    private int questions = 1, correct = 0, wrong = 0, a = 0, b = 0;
    private Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editTextNumber3);
        mButton = findViewById(R.id.button);
        mQuestion = findViewById(R.id.textView);

        a = r.nextInt(10) ;
        b = r.nextInt(10);
        mQuestion.setText(a + " + " + b);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //mEditText.setText("");

        /*
        Percentagem de 90% quando respostas todas corretas porque aparece uma que não dá para responder
        Supõe-se que o erro esteja no código em seguida
         */

        if (questions == 10) {
            Intent i = new Intent(MainActivity.this, NewActivity.class);
            i.putExtra("correct", String.valueOf(correct));
            startActivity(i);
        }

        if (mEditText.getText().toString().matches("")) {
            mEditText.setText("0");
        }

        if (Integer.valueOf(mEditText.getText().toString()) == (a + b)) {
            correct++;
        } else {
            wrong++;
        }

        a = r.nextInt(10);
        b = r.nextInt(10);

        mQuestion.setText(a + " + " + b);
        questions++;
    }
}
