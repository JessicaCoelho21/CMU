package pt.ipp.estg.cmu_fp_03_ex4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button notify;
    private Button update;
    private Button cancel;

    public static final String ACTION_DISABLE = "pt.ipp.estg.DISABLE";
    public static final String ACTION_UPDATE = "pt.ipp.estg.UPDATE";

    private IntentFilter filter;
    private MyBroadcastReceiver broadcast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();

        notify = findViewById(R.id.button);
        update = findViewById(R.id.button2);
        cancel = findViewById(R.id.button3);

        update.setEnabled(false);
        cancel.setEnabled(false);

        //Instanciar um receiver para receber intents com filtros/ações específicas
        broadcast = new MyBroadcastReceiver();

        //Instanciar IntentFilter para adicionar filtros/ações
        filter = new IntentFilter(ACTION_DISABLE);
        filter.addAction(ACTION_UPDATE);

        //Registar o receiver com os filtros/ações
        this.registerReceiver(broadcast, filter);

        notify.setOnClickListener(this);
        update.setOnClickListener(this);
        cancel.setOnClickListener(this);
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
        this.unregisterReceiver(broadcast);
        Log.d("MAIN_ACTIVITY", "onDestroy()");
    }

    public void updateNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.transferir);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "id")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Título Alterado!!")
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, mBuilder.build());
    }

    public void createNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "id")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Foi notificado!")
                .setContentText("Este é o texto da notificação")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //Intent para criar a notificação e abrir a app
        Intent click = new Intent(MainActivity.this, MainActivity.class);
        click.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingClick = PendingIntent.getActivity(this, 0, click, 0);

        //Cancela notificação e abre a app
        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(pendingClick);

        //Intent e PendingIntent com filtro/ação para dar update à notificação
        Intent updateNotification = new Intent();
        updateNotification.setAction(ACTION_UPDATE);

        PendingIntent pendingUpdateNotification = PendingIntent.getBroadcast(this, 0, updateNotification, 0);

        mBuilder.addAction(R.drawable.ic_launcher_foreground, "Atualizar notificação", pendingUpdateNotification);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, mBuilder.build());
    }

    public void deleteNotification() {
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.cancel(1);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            createNotification();
            update.setEnabled(true);
            cancel.setEnabled(true);
        }

        if (v.getId() == R.id.button2) {
            updateNotification();
        }

        if (v.getId() == R.id.button3) {
            deleteNotification();
            disableButton();
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("id", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void disableButton() {
        update.setEnabled(false);
        cancel.setEnabled(false);
    }
}