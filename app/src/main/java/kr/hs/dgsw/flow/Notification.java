package kr.hs.dgsw.flow;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import kr.hs.dgsw.flow.activity.GoOutAndSleepDocActivity;

public class Notification {

    Context context;
    NotificationCompat.Builder mBuilder;

    public Notification(Context context) {
        this.context = context;
        Intent intent = new Intent(context, GoOutAndSleepDocActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder = new NotificationCompat.Builder(context)
                .setContentTitle("외출/외박 허가")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
    }

    public void makeNoti(){
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, mBuilder.build());
    }
}
