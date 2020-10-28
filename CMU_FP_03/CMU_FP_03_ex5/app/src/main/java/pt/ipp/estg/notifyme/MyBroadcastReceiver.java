package pt.ipp.estg.notifyme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity activity = (MainActivity) context;

        if(intent.getAction() == MainActivity.ACTION_DISABLE) {
            activity.disableButton();
        }

        if(intent.getAction() == MainActivity.ACTION_UPDATE) {
            activity.updateNotification();
        }
    }
}
