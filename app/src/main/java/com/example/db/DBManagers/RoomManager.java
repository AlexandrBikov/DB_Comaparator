package com.example.db.DBManagers;

import android.arch.persistence.room.RoomDatabase;
import android.os.Handler;
import android.os.Looper;

import com.example.db.DBUtils.RoomUtils.RoomEntityDAO;
import com.example.db.Entity.RoomEntity;
import com.example.db.MainActivity;
import com.example.db.MyApp;

public class RoomManager {
    private MainActivity activity;
    private RoomEntityDAO dao;

    public RoomManager(MainActivity activity) {
        this.activity = activity;
        dao = MyApp.getInstance().getRoomDB().roomEntityDAO();
    }

    public void start(final int amount) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Handler handler = new Handler(Looper.getMainLooper());

                dao.clear();

                long startTime = System.currentTimeMillis();

                for (int i = 0; i < amount; i++) {
                    dao.insert(getEntity());
                }

                handler.post(getRunnable(System.currentTimeMillis() - startTime));
            }
        }).start();
    }

    private Runnable getRunnable(final long time) {
        return new Runnable() {
            @Override
            public void run() {
                activity.setRoomTextView(Long.toString(time));
            }
        };
    }

    public void switchJournalMode(RoomDatabase.JournalMode mode){
        dao = MyApp.getInstance().setJournalMode(mode).roomEntityDAO();
    }

    private RoomEntity getEntity() {
        return new RoomEntity("0123456789",
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
