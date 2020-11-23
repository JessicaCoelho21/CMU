package pt.ipp.estg.cmu_fp_07_ex1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.ipp.estg.cmu_fp_07_ex1.AppDatabase;
import pt.ipp.estg.cmu_fp_07_ex1.MainActivity;
import pt.ipp.estg.cmu_fp_07_ex1.Models.Contact;
import pt.ipp.estg.cmu_fp_07_ex1.R;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private Context mContext;
    private List<Contact> contacts;

    public ContactAdapter(Context mContext) {
        this.mContext = mContext;
        MainActivity.databaseWriteExecutor.execute(() -> {
            contacts = AppDatabase.getInstance(mContext).contactDAO().getAll();
        });
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Get layout inflater from context
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //Inflate Layout
        View contactView = inflater.inflate(R.layout.activity_recycler, parent, false);

        //Return a new holder instance
        return new ContactViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        //Get the data model based on position
        Contact contact = contacts.get(position);

        //Set name
        TextView textView = holder.personName;
        textView.setText(contact.name);

        //Set phone number
        TextView phoneView = holder.number;
        textView.setText(contact.number);

        //Set button
        Button button = holder.deleteButton;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.databaseWriteExecutor.execute(() -> {
                    AppDatabase.getInstance(mContext).contactDAO().delete(contact);
                    contacts = AppDatabase.getInstance(mContext).contactDAO().getAll();
                });

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewHolder extends  RecyclerView.ViewHolder {
        public TextView personName;
        public TextView number;
        public Button deleteButton;

        public ContactViewHolder(View itemView) {
            super(itemView);

            personName = itemView.findViewById(R.id.person_name);
            number = itemView.findViewById(R.id.number);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }
}
