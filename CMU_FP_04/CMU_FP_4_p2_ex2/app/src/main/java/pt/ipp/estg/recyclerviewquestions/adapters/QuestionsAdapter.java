package pt.ipp.estg.recyclerviewquestions.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.ipp.estg.recyclerviewquestions.QuestionAnswer;
import pt.ipp.estg.recyclerviewquestions.R;
import pt.ipp.estg.recyclerviewquestions.models.QuestionModel;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder>{
    private Context mContext;
    private List<QuestionModel> mQuestions;

    public QuestionsAdapter(Context mContext, List<QuestionModel> mQuestions) {
        this.mContext = mContext;
        this.mQuestions = mQuestions;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Get layout inflater from context
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //Inflate Layout
        View questionView = inflater.inflate(R.layout.item_questions, parent, false);

        //Return a new holder instance
        return new QuestionViewHolder(questionView);
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        //Get the data model based on position
        QuestionModel question = mQuestions.get(position);

        //Set name
        TextView title = holder.nameTextView;
        title.setText(question.getTitle());

        Button button = holder.questionButton;
        button.setText("Play");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, QuestionAnswer.class);
                i.putExtra("Question", question);
                mContext.startActivity(i);
            }
        });

        ImageView image = holder.answered;

        if(question.isStatus().equals("correct")) {
            image.setImageResource(R.drawable.green);
        } else if (question.isStatus().equals("wrong")) {
            image.setImageResource(R.drawable.red);
        } else if (question.isStatus().equals("empty")) {
            image.setImageResource(R.drawable.yellow);
        }
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public Button questionButton;
        public ImageView answered;

        public QuestionViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.question_title);
            questionButton = itemView.findViewById(R.id.question_button);
            answered = itemView.findViewById(R.id.imageView);
        }
    }
}


