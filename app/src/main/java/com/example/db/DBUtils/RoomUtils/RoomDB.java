package com.example.db.DBUtils.RoomUtils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.db.Entity.RoomEntity;

@Database(entities = {RoomEntity.class}, version = 1)
public abstract class RoomDB extends RoomDatabase {
    public abstract RoomEntityDAO roomEntityDAO();
}
