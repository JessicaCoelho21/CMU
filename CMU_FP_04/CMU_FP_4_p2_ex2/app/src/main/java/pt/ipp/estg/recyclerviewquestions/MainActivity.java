package pt.ipp.estg.recyclerviewquestions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.estg.recyclerviewquestions.adapters.QuestionsAdapter;
import pt.ipp.estg.recyclerviewquestions.models.QuestionModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private QuestionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create questions list
        List<QuestionModel> questions = new ArrayList<QuestionModel>();
        questions.add(new QuestionModel("Title1", "Description", "Resposta", "empty"));
        questions.add(new QuestionModel("Title2", "Description", "Resposta", "empty"));
        questions.add(new QuestionModel("Title3", "Description", "Resposta", "empty"));
        questions.add(new QuestionModel("Title4", "Description", "Resposta", "empty"));
        questions.add(new QuestionModel("Title5", "Description", "Resposta", "empty"));
        questions.add(new QuestionModel("Title6", "Description", "Resposta", "empty"));

        //Create contacts adapter
        adapter = new QuestionsAdapter(this, questions);

        //Set RecyclerView adapter
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);

        //Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Divide RecyclerView elements with a gray line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MAIN_ACTIVITY", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MAIN_ACTIVITY", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MAIN_ACTIVITY", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MAIN_ACTIVITY", "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MAIN_ACTIVITY", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MAIN_ACTIVITY", "onDestroy()");
    }
}