package com.oceanmtech.roomdatabasedemo.DemoForPractice;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StudentEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "roll_no")
    public String roll_no;

    @ColumnInfo(name = "name")
    public String name;

    public StudentEntity(String roll_no, String name) {
        this.roll_no = roll_no;
        this.name = name;
    }
}
