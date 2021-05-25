package ru.myitschool.bd;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class work_student extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_student);
        Intent intent = getIntent();
        final boolean add = intent.getBooleanExtra("add", true);
        final EditText et1 = (EditText) findViewById(R.id.editText2);
        final EditText et2 = (EditText) findViewById(R.id.editText3);
        final EditText et3 = (EditText) findViewById(R.id.editText4);
        final EditText et4 = (EditText) findViewById(R.id.editText5);
        final EditText et5 = (EditText) findViewById(R.id.editText6);
        Button confrim = (Button) findViewById(R.id.button2);
        if (!add){
            confrim.setText("Изменить данные");
            id = intent.getIntExtra("id", -1);
            Student s = db.getStudent(id);
            et1.setText(s.getFirstName());
            et2.setText(s.getSurName());
            et3.setText(s.getPatr());
            et4.setText(s.getBirthday());
            et5.setText(String.valueOf(s.getGroupnum()));

        }
        else {
            confrim.setText("Добавить студента");
        }
        confrim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (add){
                        db.addStudentData(et1.getText().toString(), et2.getText().toString(),
                                et3.getText().toString(), et4.getText().toString(), Integer.parseInt(et5.getText().toString()));
                        // Добавление челика в базу
                    }
                    else {
                        db.updateStudent(id, et1.getText().toString(), et2.getText().toString(),
                                et3.getText().toString(), et4.getText().toString(), Integer.parseInt(et5.getText().toString()));

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
