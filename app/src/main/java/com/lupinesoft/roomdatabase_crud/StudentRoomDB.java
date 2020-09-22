package com.lupinesoft.roomdatabase_crud;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = StudentInfo.class, version = 1)
public abstract class StudentRoomDB extends RoomDatabase {

    public abstract StudentDAO studentDAO();

    private static volatile StudentRoomDB studentRoomInstance;
    static StudentRoomDB getDatabase(final Context context){
        if(studentRoomInstance==null){
            synchronized (StudentRoomDB.class){
                if(studentRoomInstance==null){
                    studentRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            StudentRoomDB.class, "student_database").build();
                }
            }
        }
        return studentRoomInstance;
    }
}
