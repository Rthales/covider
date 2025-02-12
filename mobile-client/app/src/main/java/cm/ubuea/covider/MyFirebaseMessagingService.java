package cm.ubuea.covider;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    SharedPreferences sharedPreferences;
    private static final String TAG = "MyFirebaseMsgService";
    private static final String KEY = "D5D2E9164C8F786F4AE773791259FF66";
    private static final String SALT = "D5D2E9164C8F786F4AE77379125FG6SG";

    NotificationCompat.Builder notificationBuilder;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        int id = (int) System.currentTimeMillis();
        String msg = remoteMessage.getData().get("message");
        String title = remoteMessage.getData().get("title");
        sendNotification(msg, title, id);
    }

    @Override
    public void onNewToken(@NonNull String s) {
        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getResources().getString(R.string.preftoken), s);
        editor.apply();

        String username = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserName), "");
        String email = sharedPreferences.getString(getResources().getString(R.string.prefLoginUserEmail), "");
        String token = sharedPreferences.getString(getResources().getString(R.string.preftoken), "");

        //saveToken(username, email, token);
    }



    private void sendNotification(String messageBody, String title, int id) {
        Intent intent = new Intent(this, PersonHome.class);
        intent.putExtra("message", messageBody);
        intent.putExtra("title", title);
        intent.putExtra("id", id);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        String channelID = getString(R.string.channel_id);

        notificationBuilder = new NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(messageBody))

                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelID,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(id, notificationBuilder.build());
    }


}
