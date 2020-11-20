package pt.ipp.estg.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

import pt.ipp.estg.toolbar.Interfaces.IResetDialog;

public class SettingsActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, IResetDialog {
    private Toolbar toolbar;
    private RadioGroup radioGroup;
    private SharedPreferences settings;
    private DialogsFragment dialogFragment;

    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings = PreferenceManager.getDefaultSharedPreferences(this);

        //Set Radio Group
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        //Set Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Definições");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_menu:
                dialogFragment = new DialogsFragment();
                dialogFragment.show(getSupportFragmentManager(), "DIALOG_FRAGMENT");

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        editor = settings.edit();

        if(checkedId == R.id.radioWhite) {
            editor.putString("COLOR", "WHITE");
        } else if (checkedId == R.id.radioRed) {
            editor.putString("COLOR", "RED");
        } else if (checkedId == R.id.radioYellow) {
            editor.putString("COLOR", "YELLOW");
        }

        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);

        return true;
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        editor = settings.edit();
        editor.putString("COLOR", "WHITE");
        editor.commit();

        dialog.dismiss();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.dismiss();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("SETTINGS_ACTIVITY","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SETTINGS_ACTIVITY", "onResume()");
    }


    @Override
    protected void onPause(){
        super.onPause();
        Log.d("SETTINGS_ACTIVITY","onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("SETTINGS_ACTIVITY","onStop()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("SETTINGS_ACTIVITY","onRestart()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("SETTINGS_ACTIVITY","onDestroy()");
    }
}