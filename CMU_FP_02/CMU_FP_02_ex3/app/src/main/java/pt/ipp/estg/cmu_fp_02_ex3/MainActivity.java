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
    EditText mEditText;
    Button mButton;
    TextView mQuestion;
    int questions = 1, correct = 0, wrong = 0, a = 0, b = 0;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editTextNumber3);
        mButton = findViewById(R.id.button);
        mQuestion = findViewById(R.id.textView);

        a = r.nextInt((9 - 0) + 1) + 0;
        b = r.nextInt((9 - 0) + 1) + 0;
        mQuestion.setText(a + "+" + b);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //mEditText.setText("");

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

        a = r.nextInt((9 - 0) + 1) + 0;
        b = r.nextInt((9 - 0) + 1) + 0;

        mQuestion.setText(a + "+" + b);
        questions++;
    }
}
