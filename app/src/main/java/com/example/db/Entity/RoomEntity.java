package com.example.db.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class RoomEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String field1;
    public String field2;
    public String field3;
    public String field4;
    public String field5;
    public String field6;
    public String field7;
    public String field8;
    public String field9;
    public String field10;

    public RoomEntity(String field1, String field2, String field3, String field4, String field5, String field6, String field7, String field8, String field9, String field10) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.field6 = field6;
        this.field7 = field7;
        this.field8 = field8;
        this.field9 = field9;
        this.field10 = field10;
    }
}
