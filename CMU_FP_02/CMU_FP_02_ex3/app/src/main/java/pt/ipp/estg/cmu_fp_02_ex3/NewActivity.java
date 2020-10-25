package pt.ipp.estg.cmu_fp_02_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity implements View.OnClickListener {
    TextView percentage;
    Button rerun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);

        percentage = findViewById(R.id.textView8);
        rerun = findViewById(R.id.button2);

        String v = getIntent().getStringExtra("correct");
        int value = Integer.parseInt(v.toString());
        int result = (value * 100) / 10;

        percentage.setText(String.valueOf(result) + "%");

        rerun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}