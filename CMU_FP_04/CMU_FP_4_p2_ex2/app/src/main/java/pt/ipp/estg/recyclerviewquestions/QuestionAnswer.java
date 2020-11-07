package pt.ipp.estg.recyclerviewquestions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pt.ipp.estg.recyclerviewquestions.models.QuestionModel;

public class QuestionAnswer extends AppCompatActivity {
    private TextView name;
    private TextView description;
    private EditText answer;
    private Button submit;
    private QuestionModel question;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);

        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        answer = findViewById(R.id.answer);
        submit = findViewById(R.id.button);

        question = (QuestionModel) getIntent().getSerializableExtra("Question");
        pos = getIntent().getIntExtra("Pos", 0);

        name.setText(question.getTitle());
        description.setText(question.getDescription());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf((answer.getText().toString())) == Integer.parseInt(question.getAnswer())) {
                    question.setStatus("correct");
                } else {
                    question.setStatus("wrong");
                }

                finish();
            }
        });
    }

    @Override
    public void finish() {
        Intent i = new Intent();

        i.putExtra("Item", question);
        i.putExtra("repos", pos);

        //By not passing the intent in the result, the calling activity will get null data.
        setResult(RESULT_OK, i);

        super.finish();
    }
}