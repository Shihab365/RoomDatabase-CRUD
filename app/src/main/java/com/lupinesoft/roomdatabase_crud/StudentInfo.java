package com.lupinesoft.roomdatabase_crud;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "StudentInfo_DB")
public class StudentInfo {

    @PrimaryKey
    @NonNull
    private String sid;

    @ColumnInfo(name = "Name")
    private String sname;

    @ColumnInfo(name = "CGPA")
    private String scgpa;

    public StudentInfo(String sid, String sname, String scgpa) {
        this.sid = sid;
        this.sname = sname;
        this.scgpa = scgpa;
    }

    public String getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getScgpa() {
        return scgpa;
    }

    public void setSid(@NonNull String sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setScgpa(String scgpa) {
        this.scgpa = scgpa;
    }
}
