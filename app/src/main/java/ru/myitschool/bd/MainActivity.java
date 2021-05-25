package ru.myitschool.bd;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAddStudent, btnCngStudent, btnDelStudent, btnSeeStudent,
    btnAddGroup, btnCngGroup, btnDelGroup, btnSeeGroup, btnSeeGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddStudent = (Button) findViewById(R.id.button_add_s);
        btnAddStudent.setOnClickListener(this);
        btnCngStudent = (Button) findViewById(R.id.button_cng_s);
        btnCngStudent.setOnClickListener(this);
        btnDelStudent = (Button) findViewById(R.id.button_del_s);
        btnDelStudent.setOnClickListener(this);
        btnSeeStudent = (Button) findViewById(R.id.button_see_s);
        btnSeeStudent.setOnClickListener(this);
        btnAddGroup = (Button) findViewById(R.id.button_add_g);
        btnAddGroup.setOnClickListener(this);
        btnCngGroup = (Button) findViewById(R.id.button_cng_g);
        btnCngGroup.setOnClickListener(this);
        btnDelGroup = (Button) findViewById(R.id.button_del_g);
        btnDelGroup.setOnClickListener(this);
        btnSeeGroup = (Button) findViewById(R.id.button_see_g);
        btnSeeGroup.setOnClickListener(this);
        btnSeeGroups= (Button) findViewById(R.id.button_see_gs);
        btnSeeGroups.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_add_s:
                startActivity(new Intent(this, work_student.class).putExtra("add", true));
                break;
            case R.id.button_cng_s:
                startActivity(new Intent(this, number_student.class).putExtra("chg", true));
                break;
            case R.id.button_del_s:
                startActivity(new Intent(this, number_student.class).putExtra("chg", false));
                break;
            case R.id.button_see_s:
                startActivity(new Intent(MainActivity.this, ViewListStudents.class).putExtra("surn", "").putExtra("num", -1));
                break;
            case R.id.button_add_g:
                startActivity(new Intent(this, work_group.class).putExtra("add", true));
                break;
            case R.id.button_cng_g:
                startActivity(new Intent(this, number_group.class).putExtra("chg", true));
                break;
            case R.id.button_del_g:
                startActivity(new Intent(this, number_group.class).putExtra("chg", false));
                break;
            case R.id.button_see_g:
                startActivity(new Intent(MainActivity.this, ViewListGroups.class));
                break;
            case R.id.button_see_gs:
                startActivity(new Intent(MainActivity.this, StudentSearch.class));
                break;
        }

    }
}
