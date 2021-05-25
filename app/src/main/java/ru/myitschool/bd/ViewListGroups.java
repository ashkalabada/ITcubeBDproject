package ru.myitschool.bd;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ViewListGroups extends AppCompatActivity {

    DatabaseHelper myDB;
    ArrayList<Group> groupArrayList;
    ListView listView;
    Group group;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_item);

        myDB = new DatabaseHelper(this);

        groupArrayList = new ArrayList<>();
        Cursor data = myDB.getListContentsGroup();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(ViewListGroups.this,"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(data.moveToNext()){
                group = new Group(data.getInt(0), data.getInt(1), data.getString(2));
                Log.d("MSGG", String.valueOf(data.getInt(0)));
                groupArrayList.add(i, group);
                i++;
            }
            GroupAdapter adapter =  new GroupAdapter(this,R.layout.activity_watch_group, groupArrayList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }
}
