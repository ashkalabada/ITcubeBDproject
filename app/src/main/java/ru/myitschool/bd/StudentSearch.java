package ru.myitschool.bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentSearch extends AppCompatActivity {
    EditText surn, groupN;
    String surnameS;
    Button b;
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_search);
        surn = (EditText) findViewById(R.id.ed6);
        groupN = (EditText) findViewById(R.id.ed7);
        b = (Button)findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                search();
             }
         }
        );
    }

    void search(){
        surnameS = surn.getText().toString();
        if (!groupN.getText().toString().isEmpty())
            num = Integer.parseInt(groupN.getText().toString());
        else
            num = -1;
        Log.d("MSGG", surnameS + num);
        startActivity(new Intent(StudentSearch.this, ViewListStudents.class).putExtra("surn", surnameS).putExtra("num", num));
    }
}
