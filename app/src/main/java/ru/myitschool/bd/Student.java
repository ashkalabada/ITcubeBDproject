package ru.myitschool.bd;

public class Student {
    private String FirstName;
    private String SurName;
    private String Patr;
    private String Birthday;
    private int Groupnum, ID;

    public Student(int id, String firstName, String surName, String patr, String birthday, int groupnum) {
        ID = id;
        FirstName = firstName;
        SurName = surName;
        Patr = patr;
        Birthday = birthday;
        Groupnum = groupnum;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getPatr() {
        return Patr;
    }

    public void setPatr(String patr) {
        Patr = patr;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public int getGroupnum() {
        return Groupnum;
    }

    public void setGroupnum(int groupnum) {
        Groupnum = groupnum;
    }
}
