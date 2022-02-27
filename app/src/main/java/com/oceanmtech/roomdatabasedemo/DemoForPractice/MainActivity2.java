package com.oceanmtech.roomdatabasedemo.DemoForPractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.oceanmtech.roomdatabasedemo.R;
import com.oceanmtech.roomdatabasedemo.databinding.ActivityMain2Binding;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    MainActivity2 mContext = MainActivity2.this;
    ActivityMain2Binding mBinding;
    StudentDatabase studentDatabase;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(mContext, R.layout.activity_main2);

        dialog = new ProgressDialog(this);
        setupStudentDatabase();
        onClickListeners();
    }

    private void onClickListeners() {
        mBinding.btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentEntity student2 = new StudentEntity(mBinding.tvRollNo.getText().toString(),mBinding.tvName.getText().toString());
                studentDatabase.dao().insertStudent(student2);
            }
        });
        mBinding.btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<StudentEntity> stuList = studentDatabase.dao().getAllStudents();
                for(int i=0;i<stuList.size();i++){
                    Log.d("StudentList", "Roll No : "+stuList.get(i).roll_no+ " Name : "+stuList.get(i).name);
                }
            }
        });
        mBinding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentDatabase.dao().updateStudent(mBinding.tvUpdateName.getText().toString(), mBinding.tvRollNo2.getText().toString());
            }
        });
        mBinding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentDatabase.dao().deleteStudent(mBinding.tvRollNo3.getText().toString());
            }
        });
        mBinding.btnDialogShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setMessage("Updating...");
                dialog.setCancelable(false);
                //dialog.show();
            }
        });
        mBinding.btnDialogDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void setupStudentDatabase() {

        studentDatabase = Room.databaseBuilder(mContext, StudentDatabase.class, "studentDB2").allowMainThreadQueries().build();
    }
}