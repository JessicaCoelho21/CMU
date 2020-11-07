package pt.ipp.estg.recyclerviewquestions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        List<QuestionModel> questions = createQuestions(3);

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == QuestionsAdapter.REQUEST_CODE && resultCode == RESULT_OK) {
            QuestionModel passedItem = (QuestionModel) data.getExtras().get("Item");

            int postition = (Integer) data.getExtras().get("repos");

            adapter.update(postition, passedItem);
            adapter.notifyDataSetChanged();
        }
    }

    private List<QuestionModel> createQuestions (int size) {
        List<QuestionModel> list = new ArrayList<>(size);
        Random r = new Random();

        for(int i = 0; i < size; i++) {
            int a = r.nextInt(10);
            int b = r.nextInt(10);
            int answer = a + b;

            String description = ("Qual é o valor de " + a + " + " + b + "?");

            list.add(i, new QuestionModel("Question " + (i + 1), description, String.valueOf(answer)));
        }

        return list;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MAIN_ACTIVITY", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();

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