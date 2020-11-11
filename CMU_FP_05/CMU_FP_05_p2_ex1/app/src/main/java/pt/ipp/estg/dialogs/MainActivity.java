package pt.ipp.estg.dialogs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IDialog{
    private LoginFragment loginFragment;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextView);

        loginFragment = new LoginFragment();
        loginFragment.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        if(LoginFragment.verify) {
            textView.setText("Logged in!!");
        } else {
            textView.setText("Login failed!!");
            dialog.dismiss();
            finish();
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.dismiss();
        finish();
    }
}