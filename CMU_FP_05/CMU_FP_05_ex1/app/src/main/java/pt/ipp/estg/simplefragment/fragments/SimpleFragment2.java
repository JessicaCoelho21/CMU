package pt.ipp.estg.simplefragment.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pt.ipp.estg.simplefragment.R;

public class SimpleFragment2 extends Fragment {
    private TextView textView2;

    public SimpleFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mContentView = inflater.inflate(R.layout.fragment_simple2, container, false);

        textView2 = mContentView.findViewById(R.id.textView2);
        textView2.setText(getArguments().getString("value"));

        return mContentView;
    }
}