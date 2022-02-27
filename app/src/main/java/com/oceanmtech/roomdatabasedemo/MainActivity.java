package com.oceanmtech.roomdatabasedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.oceanmtech.roomdatabasedemo.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainActivity mContext = MainActivity.this;
    ActivityMainBinding mBinding;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(mContext, R.layout.activity_main);

        setupDatabase();
        onClickListeners();
    }

    private void onClickListeners() {
        mBinding.btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(mBinding.tvFisrtName.getText().toString(), mBinding.tvLastName.getText().toString(),
                        mBinding.tvClass.getText().toString());
                myDatabase.dao().studentInsertion(student);
            }
        });
        mBinding.btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> stuData = myDatabase.dao().getStudent();

                for (int i = 0; i < stuData.size(); i++) {
                    Log.d("Student_Data", stuData.get(i).getStuId() + ": " + stuData.get(i).getStuFirstName() + ": " +
                            stuData.get(i).getStuLastName() + ": " + stuData.get(i).getStuClass());
                }
            }
        });
        mBinding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase.dao().updateStu(mBinding.tvUpdateName.getText().toString(), Integer.parseInt(mBinding.tvUpdateId.getText().toString()));
            }
        });
        mBinding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase.dao().deleteStu(Integer.parseInt(mBinding.tvDeleteId.getText().toString()));
            }
        });
    }

    private void setupDatabase() {
        myDatabase = Room.databaseBuilder(mContext, MyDatabase.class, "StudentDB").allowMainThreadQueries().build();
    }
}