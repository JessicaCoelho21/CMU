package pt.ipp.estg.toolbar.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.ipp.estg.toolbar.ContactDetails;
import pt.ipp.estg.toolbar.Models.Contact;
import pt.ipp.estg.toolbar.R;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private Context mContext;
    private List<Contact> contacts;

    public ContactAdapter(Context mContext, List<Contact> contacts) {
        this.mContext = mContext;
        this.contacts = contacts;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Get layout inflater from context
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //Inflate Layout
        View contactView = inflater.inflate(R.layout.recycler_item, parent, false);

        //Return a new holder instance
        return new ContactViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        //Get the data model based on position
        Contact contact = contacts.get(position);

        //Set name
        TextView textView = holder.personName;
        textView.setText(contact.getName());

        //Set button status
        Button button = holder.messageButton;
        button.setText(contact.isOnline() ? "Message" : "Offline");
        button.setEnabled(contact.isOnline());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ContactDetails.class);
                i.putExtra("CONTACT", contact);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewHolder extends  RecyclerView.ViewHolder {
        public TextView personName;
        public Button messageButton;

        public ContactViewHolder(View itemView) {
            super(itemView);

            personName = itemView.findViewById(R.id.person_name);
            messageButton = itemView.findViewById(R.id.message_button);
        }
    }
}
