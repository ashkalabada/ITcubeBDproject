package ru.myitschool.bd;

public class Group {
    private int groupnum, id;
    private String groupName;

    public Group(int id, int groupnum, String groupName) {
        this.id = id;
        this.groupnum = groupnum;
        this.groupName = groupName;
    }

    public int getGroupnum() {
        return groupnum;
    }

    public void setGroupnum(int groupnum) {
        this.groupnum = groupnum;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int get_id() {
        return id;
    }
}
