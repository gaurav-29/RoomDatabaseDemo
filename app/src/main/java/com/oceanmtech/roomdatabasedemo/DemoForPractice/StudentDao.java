package com.oceanmtech.roomdatabasedemo.DemoForPractice;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    public void insertStudent(StudentEntity student);

    @Query("Select * from StudentEntity")
    List<StudentEntity> getAllStudents();

    @Query("Update StudentEntity set name = :name where roll_no = :roll_no")
    void updateStudent(String name, String roll_no);

    @Query("Delete from StudentEntity where roll_no = :roll_no")
    void deleteStudent(String roll_no);
}
