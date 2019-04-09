package com.example.db.DBManagers;

import android.os.Handler;
import android.os.Looper;

import com.example.db.DBUtils.ObjectBox.ObjectBox;
import com.example.db.Entity.EntityObjectBox;
import com.example.db.MainActivity;

import io.objectbox.Box;

public class ObjectBoxManager {

    private Box<EntityObjectBox> objectBox = ObjectBox.get().boxFor(EntityObjectBox.class);
    private MainActivity activity;

    public ObjectBoxManager(MainActivity activity){
        this.activity = activity;
    }

    public void start(final int amount) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                objectBox.removeAll();

                Handler handler = new Handler(Looper.getMainLooper());

                long startTime = System.currentTimeMillis();
                for (int i = 0; i < amount; i++) {
                    objectBox.put(getEntity());
                }

                handler.post(getRunnable(System.currentTimeMillis() - startTime));
            }
        }).start();

    }

    private Runnable getRunnable(final long time){
        return new Runnable() {
            @Override
            public void run() {
                activity.setObjectBoxTextView(Long.toString(time));
            }
        };
    }

    private EntityObjectBox getEntity() {
        return new EntityObjectBox(
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
