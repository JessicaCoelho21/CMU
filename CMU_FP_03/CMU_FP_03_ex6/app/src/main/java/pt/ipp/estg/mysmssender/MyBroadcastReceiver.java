package pt.ipp.estg.mysmssender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity activity = (MainActivity) context;

        if (intent.getAction() == activity.ACTION_SMS_SEND) {
            Toast.makeText(context, "SMS enviado!", Toast.LENGTH_LONG).show();
        } else if (intent.getAction() == activity.ACTION_SMS_DELIVERED) {
            Toast.makeText(context, "SMS recebido!", Toast.LENGTH_LONG).show();
        }
    }
}
