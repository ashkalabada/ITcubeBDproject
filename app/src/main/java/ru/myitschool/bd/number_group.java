package ru.myitschool.bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class number_group extends AppCompatActivity {
    boolean chg;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_group);
        Intent intent = getIntent();
        chg = intent.getBooleanExtra("chg", true);
        et = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        if (chg){
            et.setHint("Введите id изменяемой группы");
        }
        else{
            et.setHint("Введите id удаляемой группы");
        }
    }

    public void workNum(View view) {
        if (chg) {
            startActivity(new Intent(this, work_group.class).putExtra("add", false).putExtra("id", Integer.parseInt(et.getText().toString())));
        } else {
            // Удаление группы с базы
            DatabaseHelper db = new DatabaseHelper(this);
            db.deleteGroup(Integer.parseInt(et.getText().toString()));
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
