package pt.ipp.estg.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.content.DialogInterface;

import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class LoginFragment extends DialogFragment {
    private IDialog iDialog;
    private TextView username;
    private TextView password;
    public static boolean verify;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iDialog = (IDialog) context;
    }

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_login, null);

        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);

        builder.setView(view).setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                verify = verify(username.getText().toString(), password.getText().toString());
                iDialog.onDialogPositiveClick(LoginFragment.this);
            }
        })

        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                iDialog.onDialogNegativeClick(LoginFragment.this);
            }
        });

        return builder.create();
    }

    private boolean verify(String username, String password) {
        if(username.equals("jessica") && password.equals("beatriz")) {
            return true;
        } else {
            return false;
        }
    }
}