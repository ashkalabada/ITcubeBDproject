package ru.myitschool.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "myproject.db";
    public static final String TABLE_NAME1 = "students";
    public static final String COL0 = "ID";
    public static final String COL1 = "NAME";
    public static final String COL2 = "SURNAME";
    public static final String COL3 = "PATR";
    public static final String COL4 = "BIRTHDAY";
    public static final String COL5 = "FACULTET";

    public static final String TABLE_NAME2 = "groups";
    public static final String COL10 = "ID";
    public static final String COL11 = "NUMBER";
    public static final String COL12 = "NAME_GROUP";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NAME TEXT, SURNAME TEXT, PATR TEXT, BIRTHDAY TEXT, FACULTET INTEGER)";
        db.execSQL(createTable);
        String createTable2 = "CREATE TABLE " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NUMBER INT, NAME_GROUP TEXT)";
        db.execSQL(createTable2);
        Log.d("MSGG", "Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    public Student getStudent(int id){
        Student s = null;
        if (id > 0){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_NAME1, null, " id = ? ",new String[] { String.valueOf(id) }, null, null, null);
        c.moveToFirst();
//        Log.d("MSGG", "" + c.getInt(0));
        s = new Student(c.getInt(0), c.getString(1), c.getString(2),
                c.getString(3), c.getString(4), c.getInt(5));
        }
        return s;
    }

    public Group getGroup(int id){
        Group g = null;
        if (id > 0){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor c = db.query(TABLE_NAME2, null, " id = ? ",new String[] { String.valueOf(id) }, null, null, null);
            c.moveToFirst();
//        Log.d("MSGG", "" + c.getInt(0));
            if (c.getCount() > 0)
                g = new Group(c.getInt(0), c.getInt(1), c.getString(2));
        }
        return g;
    }

    public boolean addStudentData(String fName, String sName, String Patr, String Bday, int GroupNum) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, fName);
        contentValues.put(COL2, sName);
        contentValues.put(COL3, Patr);
        contentValues.put(COL4, Bday);
        contentValues.put(COL5, GroupNum);

        long result = db.insert(TABLE_NAME1, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateStudent(int id, String fName, String sName, String Patr, String Bday, int GroupNum){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, fName);
        contentValues.put(COL2, sName);
        contentValues.put(COL3, Patr);
        contentValues.put(COL4, Bday);
        contentValues.put(COL5, GroupNum);

        long result = db.update(TABLE_NAME1, contentValues,"id = ?", new String[] { String.valueOf(id) } );

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addGroupData(int GroupNum, String fName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL11, GroupNum);
        contentValues.put(COL12, fName);
        long result = db.insert(TABLE_NAME2, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean updateGroupData(int GroupNum, String fName, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL11, GroupNum);
        contentValues.put(COL12, fName);
        long result = db.update(TABLE_NAME2, contentValues, "id = ?", new String[] { String.valueOf(id) });

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME1, "id = " + id, null);
    }

    public void deleteGroup(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME2, "id = " + id, null);
    }

    public Cursor getListContentsStudents(){
        Log.d("MSGG", "All students");
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME1, null);
        return data;
    }

    public Cursor getListContentsSomeStudents(String surname, int group_id){
        Log.d("MSGG", "Not only all students" + surname + group_id);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME1 + " WHERE " + COL2 + " = " + "\"" + surname + "\"" +
                " OR " + COL5 + " = " + group_id, null);
        return data;
    }

    public Cursor getListContentsGroup(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME2, null);
        return data;
    }
}