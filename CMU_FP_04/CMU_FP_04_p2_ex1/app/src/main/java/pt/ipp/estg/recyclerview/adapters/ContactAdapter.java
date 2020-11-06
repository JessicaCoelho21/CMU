package pt.ipp.estg.recyclerview.adapters;

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

import pt.ipp.estg.recyclerview.ContactDetails;
import pt.ipp.estg.recyclerview.R;
import pt.ipp.estg.recyclerview.models.Contacts;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private Context mContext;
    private List<Contacts> mContacts;

    public ContactAdapter(Context context, List<Contacts> contacts) {
        mContext = context;
        mContacts = contacts;
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Get layout inflater from context
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //Inflate Layout
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        //Return a new holder instance
        return new ContactViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder viewHolder, int position) {
        //Get the data model based on position
        Contacts contact = mContacts.get(position);

        //Set name
        TextView textView = viewHolder.nameTextView;
        textView.setText(contact.getmName());

        //Set button status
        Button button = viewHolder.messageButton;
        button.setText(contact.ismOnline() ? "Message" : "Offline");
        button.setEnabled(contact.ismOnline());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ContactDetails.class);
                i.putExtra("Contact", contact);
                mContext.startActivity(i);
            }
        });

        ImageView image = viewHolder.online;

        if(contact.ismOnline()) {
            image.setImageResource(R.drawable.green);
        } else {
            image.setImageResource(R.drawable.red);
        }
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public Button messageButton;
        public ImageView online;

        public ContactViewHolder(View itemView) {
            super(itemView);

            nameTextView =itemView.findViewById(R.id.contact_name);
            messageButton = itemView.findViewById(R.id.message_button);
            online = itemView.findViewById(R.id.imageView);
        }
    }
}

