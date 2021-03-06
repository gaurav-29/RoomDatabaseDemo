package com.oceanmtech.roomdatabasedemo.DemoForPractice;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.oceanmtech.roomdatabasedemo.Student;

@Database(entities = {StudentEntity.class}, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDao dao();
}
