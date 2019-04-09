package com.example.db.DBManagers;

import android.os.Handler;
import android.os.Looper;

import com.example.db.Entity.RealmEntity;
import com.example.db.MainActivity;

import io.realm.Realm;

public class RealmManager {
    private MainActivity activity;

    public RealmManager(MainActivity activity){
        this.activity = activity;
    }

    public void start(final int amount) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Realm realm = Realm.getDefaultInstance();

                deleteAll(realm);

                Handler handler = new Handler(Looper.getMainLooper());

                RealmEntity entity = getEntity();

                long startTime = System.currentTimeMillis();

                realm.beginTransaction();
                for (int i = 0; i < amount; i++) {
                    entity.id = i;
                    realm.copyToRealm(entity);
                }
                realm.commitTransaction();

                handler.post(getRunnable(System.currentTimeMillis() - startTime));

                realm.close();
            }
        }).start();

    }

    private void deleteAll(Realm realm){
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    private Runnable getRunnable(final long time){
        return new Runnable() {
            @Override
            public void run() {
                activity.setRealmTextView(Long.toString(time));
            }
        };
    }

    private RealmEntity getEntity() {
        return new RealmEntity(
                "0123456789",
                "0123456789",
                "0123456789",
                "0123456789",
                "0123456789",
                "0123456789",
                "0123456789",
                "0123456789",
                "0123456789",
                "0123456789");
    }
}
