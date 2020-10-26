package pt.ipp.estg.cmu_fp_03_ex3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button notify;
    private Button update;
    private Button cancel;

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

        notify.setOnClickListener(this);
        update.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "id")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Foi notificado!")
                .setContentText("Este é o texto da notificação")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        if (v.getId() == R.id.button) {
            notificationManager.notify(1, mBuilder.build());

            update.setEnabled(true);
            cancel.setEnabled(true);
        }

        if (v.getId() == R.id.button2) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.transferir);

            mBuilder.setContentTitle("Título Alterado!!");
            mBuilder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap)).build();
            notificationManager.notify(1, mBuilder.build());
        }

        if (v.getId() == R.id.button3) {
            notificationManager.cancel(1);
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
}