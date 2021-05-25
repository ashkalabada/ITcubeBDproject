package ru.myitschool.bd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GroupAdapter extends ArrayAdapter<Group> {
    private LayoutInflater mInflater;
    private ArrayList<Group> groups;
    private int mViewResourceId;

    public GroupAdapter(Context context, int textViewResourceId, ArrayList<Group> groups1) {
            super(context, textViewResourceId, groups1);
            this.groups = groups1;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mViewResourceId = textViewResourceId;
            }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

         Group group1 = groups.get(position);

        if (group1 != null) {
            TextView Groupnum = (TextView) convertView.findViewById(R.id.textGroupNums);
            TextView GroupName = (TextView) convertView.findViewById(R.id.textFacultet);
            TextView GroupID = (TextView) convertView.findViewById(R.id.textGroupNumsID2);
            if (Groupnum != null) {
                Groupnum.setText(String.valueOf(group1.getGroupnum()));
            }
            if (GroupName != null) {
                GroupName.setText(group1.getGroupName());
            }
            if (GroupID != null) {
                GroupID.setText(String.valueOf(group1.get_id()));
            }
        }

        return convertView;
    }
}

