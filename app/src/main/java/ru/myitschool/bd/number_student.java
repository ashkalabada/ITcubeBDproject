package ru.myitschool.bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class number_student extends AppCompatActivity {
    boolean chg;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_student);
        Intent intent = getIntent();
        chg = intent.getBooleanExtra("chg", true);
        et = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        if (chg){
            et.setHint("Введите id изменяемого студента");
        }
        else{
            et.setHint("Введите id удаляемого студента");
        }
    }

    public void workID(View view) {
        if (chg){
            startActivity(new Intent(this, work_student.class).putExtra("add", false).putExtra("id", Integer.parseInt(et.getText().toString())));
        }
        else {
            // Удаление челика с базы
            DatabaseHelper db = new DatabaseHelper(this);
            db.deleteStudent(Integer.parseInt(et.getText().toString()));
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
