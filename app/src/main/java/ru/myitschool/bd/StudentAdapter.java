package ru.myitschool.bd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
    private LayoutInflater mInflater;
    private ArrayList<Student> users;
    private int mViewResourceId;

    public StudentAdapter(Context context, int textViewResourceId, ArrayList<Student> students) {
        super(context, textViewResourceId, students);
        this.users = students;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Student student = users.get(position);

        if (student != null) {
            TextView firstName = (TextView) convertView.findViewById(R.id.textName);
            TextView lastName = (TextView) convertView.findViewById(R.id.textSurName);
            TextView patr = (TextView) convertView.findViewById(R.id.textPatr);
            TextView birtday = (TextView) convertView.findViewById(R.id.textBirthday);
            TextView group = (TextView) convertView.findViewById(R.id.textGroupN);
            TextView id = (TextView) convertView.findViewById(R.id.idfield);
            if (id != null) {
                id.setText(String.valueOf(student.getID()));
            }
            if (firstName != null) {
                firstName.setText(student.getFirstName());
            }
            if (lastName != null) {
                lastName.setText((student.getSurName()));
            }
            if (patr != null) {
                patr.setText((student.getPatr()));
            }
            if (birtday != null) {
                birtday.setText((student.getBirthday()));
            }
            if (group != null) {
                group.setText(String.valueOf(student.getGroupnum()));
            }

        }

        return convertView;
    }
}
