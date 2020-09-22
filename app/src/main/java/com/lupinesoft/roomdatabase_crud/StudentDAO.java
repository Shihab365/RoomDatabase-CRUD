package com.lupinesoft.roomdatabase_crud;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {
    @Insert
    void insertStudentInfo(StudentInfo studentInfo);

    @Query("SELECT * FROM StudentInfo_DB")
    LiveData<List<StudentInfo>> getAllInfo();

    @Update
    void updateStudentInfo(StudentInfo studentInfo);

    @Delete
    void deleteStudentInfo(StudentInfo studentInfo);
}
