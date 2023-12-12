package fr.univbrest.p2_services;

import static android.app.Service.START_STICKY;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.security.Provider;
import java.util.List;
import java.util.Map;

public class MonService extends Service {

    boolean marche;
    int c=0;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flag, int startId) {
         marche = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
               while(marche) {
                     c++;
                    Log.i("FANTOME", ""+c);

                   Intent broadcastIntent = new Intent("mister.fantome");
                   broadcastIntent.putExtra("val", c);
                   sendBroadcast(broadcastIntent);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        marche=false;
        Log.i("destroy", "Service détruit.");
    }


}
