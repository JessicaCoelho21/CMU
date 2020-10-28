package pt.ipp.estg.mysmssender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mText;
    private Button mButton;

    private static final int REQUEST_SELECT_PHONE_NUMBER = 1;
    private static final int MY_PERMITION_REQUEST_SEND_SMS = 100;

    private String message;
    private SmsManager smsManager;

    public static final String ACTION_SMS_SEND = "pt.ipp.estg.SEND_SMS";
    public static final String ACTION_SMS_DELIVERED = "pt.ipp.estg.SMS_DELIVERED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = findViewById(R.id.editText);
        mButton = findViewById(R.id.button);

        smsManager = SmsManager.getDefault();

        IntentFilter filter = new IntentFilter(ACTION_SMS_SEND);
        filter.addAction(ACTION_SMS_DELIVERED);

        MyBroadcastReceiver smsReceiver = new MyBroadcastReceiver();

        this.registerReceiver(smsReceiver, filter);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        message = mText.getText().toString();
        checkPermissions();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MAIN_ACTIVITY", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MAIN_ACTIVITY", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MAIN_ACTIVITY", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MAIN_ACTIVITY", "onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MAIN_ACTIVITY", "onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MAIN_ACTIVITY", "onDestroy()");
    }

    /**
     * Verifica as permissões do utilizador
     */
    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            selectContact();
        } else {
            requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMITION_REQUEST_SEND_SMS);
        }
    }

    /**
     * Pede as permissões ao utilizador
     *
     * @param mainActivity
     * @param strings
     * @param myPermitionRequestSendSms
     */
    private void requestPermissions(MainActivity mainActivity, String[] strings, int myPermitionRequestSendSms) {
        if (ContextCompat.checkSelfPermission(mainActivity, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

            } else {
                ActivityCompat.requestPermissions(this, strings, myPermitionRequestSendSms);
            }
        }
    }

    /**
     * Seleciona o contacto
     */
    public void selectContact() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER);
        }
    }

    /**
     * Deixa selecionar o contacto
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SELECT_PHONE_NUMBER && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};

            Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(numberIndex);

                sendSMS(number);
            }
        }
    }

    /**
     * Envia SMS para o número escolhido
     *
     * @param num
     */
    public void sendSMS(String num) {
        Intent sendIntent = new Intent(ACTION_SMS_SEND);
        PendingIntent pendingSendIntent = PendingIntent.getBroadcast(this, 0, sendIntent, 0);

        Intent deliverIntent = new Intent(ACTION_SMS_DELIVERED);
        PendingIntent pendingDeliverSend = PendingIntent.getBroadcast(this, 0, deliverIntent, 0);

        smsManager.sendTextMessage(num, null, message, pendingSendIntent, pendingDeliverSend);
    }
}