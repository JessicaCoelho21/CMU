package pt.ipp.estg.hugearraylist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import pt.ipp.estg.hugearraylist.R;
import pt.ipp.estg.hugearraylist.models.Contact;

public class MyListAdapter extends ArrayAdapter<Contact> {
    private Context mContext;
    private List<Contact> mContacts;

    public MyListAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mContacts = objects;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row_layout, null);
        }

        Contact contact = mContacts.get(position);

        TextView txtName = (TextView) v.findViewById(R.id.textView);
        txtName.setText(contact.getName());

        return v;
    }

}
