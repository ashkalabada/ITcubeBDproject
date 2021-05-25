package ru.myitschool.bd;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ViewListStudents extends AppCompatActivity {
    DatabaseHelper myDB;
    ArrayList<Student> studentsList;
    ListView listView;
    Student student;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_item);

        myDB = new DatabaseHelper(this);

        studentsList = new ArrayList<>();
        Intent intent = getIntent();
        int num = intent.getIntExtra("num", -1);
        String s = intent.getStringExtra("surn");
        Cursor data = null;
        if (num == -1 && (s == null || s.isEmpty())){
            data = myDB.getListContentsStudents();
        }
        else {
            data = myDB.getListContentsSomeStudents(s, num);
        }
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(ViewListStudents.this,"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(data.moveToNext()){
                student = new Student(data.getInt(0), data.getString(1),data.getString(2),data.getString(3),data.getString(4),data.getInt(5));
                studentsList.add(i, student);
                i++;
            }
            StudentAdapter adapter =  new StudentAdapter(this,R.layout.activity_watch_student, studentsList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }
}
