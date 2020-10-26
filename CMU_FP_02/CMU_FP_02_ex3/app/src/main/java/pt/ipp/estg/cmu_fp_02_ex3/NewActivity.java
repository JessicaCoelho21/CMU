package pt.ipp.estg.cmu_fp_02_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class NewActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView percentage;
    private Button rerun;
    private ImageView image;
    private BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);

        percentage = findViewById(R.id.textView8);
        rerun = findViewById(R.id.button2);
        image = findViewById(R.id.imageView);
        chart = (BarChart)findViewById(R.id.chart2);

        String v = getIntent().getStringExtra("correct");
        int value = Integer.parseInt(v);
        int result = Math.round((value * 100) / 10);
        String resultS = Integer.toString(result);

        percentage.setText(resultS + "%");

        if(result >= 50){
            image.setImageResource(R.drawable.a);
        } else{
            image.setImageResource(R.drawable.f);
        }

        List<BarEntry> entry = new ArrayList<>();

        entry.add(new BarEntry(0f, value));

        BarDataSet set = new BarDataSet(entry, "BarDataSet");
        BarData data = new BarData(set);

        data.setBarWidth(0.7f);
        chart.setData(data);
        chart.setFitBars(true);
        chart.invalidate();

        rerun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(NewActivity.this, MainActivity.class);
        startActivity(i);

        //finish();
    }
}