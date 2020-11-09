package pt.ipp.estg.simplefragment.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pt.ipp.estg.simplefragment.Interface;
import pt.ipp.estg.simplefragment.R;

public class SimpleFragment extends Fragment {
    private EditText editText;
    private Button button;

    Interface in;

    public SimpleFragment() {
        // Required empty public constructor
    }

    public static SimpleFragment newInstance(String param1, String param2) {
        SimpleFragment fragment = new SimpleFragment();

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        in = (Interface) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mContentView = inflater.inflate(R.layout.fragment_simple, container, false);

        button = mContentView.findViewById(R.id.button);
        editText = mContentView.findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in.sendTextToFragment(editText.getText().toString());
            }
        });

        return mContentView;
    }
}