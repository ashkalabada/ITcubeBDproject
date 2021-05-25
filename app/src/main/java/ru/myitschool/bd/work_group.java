package ru.myitschool.bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class work_group extends AppCompatActivity {
    DatabaseHelper db;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this);
        setContentView(R.layout.activity_work_group);
        Intent intent = getIntent();
        final boolean add = intent.getBooleanExtra("add", true);
        final EditText et1 = (EditText) findViewById(R.id.editText2);
        final EditText et2 = (EditText) findViewById(R.id.editText3);;
        if (!add){
            // Запрос в базу данных на получение id данного групца
            // Заполнение всех et данными группы
        }
        Button confrim = (Button) findViewById(R.id.button2);
        if (!add){
            confrim.setText("Изменить данные");
            id = intent.getIntExtra("id", -1);
            Group g = db.getGroup(id);
            if (g != null){
                et1.setText(String.valueOf(g.getGroupnum()));
                et2.setText(g.getGroupName());
            }
        }
        else {
            confrim.setText("Добавить группу");
        }
        confrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (add){
                   db.addGroupData(Integer.parseInt(et1.getText().toString()), et2.getText().toString());
               }
               else {
                   db.updateGroupData(Integer.parseInt(et1.getText().toString()), et2.getText().toString(), id);
               }
               goToMainActivity();
            }
        }
        );

    }

    private void goToMainActivity(){
        startActivity(new Intent(this, MainActivity.class));
    }
}
