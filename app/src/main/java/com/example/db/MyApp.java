package com.example.db;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.example.db.DBUtils.ObjectBox.ObjectBox;
import com.example.db.DBUtils.RoomUtils.RoomDB;

public class MyApp extends Application {
    private RoomDB roomDB;
    private static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        initObjectBox();
        initRoom();
    }

    private void initObjectBox(){
        ObjectBox.init(this);
    }

    private void initRoom(){
        roomDB = Room.databaseBuilder(getApplicationContext(), RoomDB.class, "roomDB").build();
    }

    public RoomDB getRoomDB() {
        return roomDB;
    }

    public static MyApp getInstance() {
        return instance;
    }

    public RoomDB setJournalMode(RoomDatabase.JournalMode mode){
        roomDB.close();
        return Room.databaseBuilder(getApplicationContext(), RoomDB.class, "roomDB")
                .setJournalMode(mode).build();
    }
}
