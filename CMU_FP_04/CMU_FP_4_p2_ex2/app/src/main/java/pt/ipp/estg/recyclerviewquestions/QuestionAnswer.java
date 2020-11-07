package pt.ipp.estg.recyclerviewquestions;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);

        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        answer = findViewById(R.id.answer);
        submit = findViewById(R.id.button);

        QuestionModel question = (QuestionModel) getIntent().getSerializableExtra("Question");

        name.setText(question.getTitle());
        description.setText(question.getDescription());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.getText().toString().equals(question.getAnswer())) {
                    question.setStatus("correct");
                } else if(!answer.getText().toString().equals(question.getAnswer())) {
                    question.setStatus("wrong");
                }

                finish();
            }
        });
    }
}