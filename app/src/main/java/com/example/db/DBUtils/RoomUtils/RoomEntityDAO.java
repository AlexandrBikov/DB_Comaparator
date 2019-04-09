package com.example.db.DBUtils.RoomUtils;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.db.Entity.RoomEntity;

import java.util.List;

@Dao
public interface RoomEntityDAO {

    @Query("DELETE FROM roomEntity")
    void clear();

    @Query("SELECT * FROM roomEntity")
    List<RoomEntity> getAll();

    @Query("SELECT * FROM roomEntity WHERE id = :id")
    RoomEntity getById(long id);

    @Insert
    void insert(RoomEntity entity);

    @Update
    void update(RoomEntity entity);

    @Delete
    void delete(RoomEntity entity);
}
