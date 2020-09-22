package com.lupinesoft.roomdatabase_crud;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    private StudentDAO studentDAO;
    private StudentRoomDB studentRoomDB;
    LiveData<List<StudentInfo>> mAllInfos;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        studentRoomDB = StudentRoomDB.getDatabase(application);
        studentDAO = studentRoomDB.studentDAO();
        mAllInfos = studentDAO.getAllInfo();
    }

    LiveData<List<StudentInfo>> getmAllInfos(){
        return mAllInfos;
    }

    public void insertStudentInfo(StudentInfo studentInfo){
        new InsertAsyncTask(studentDAO).execute(studentInfo);
    }

    public void updateStudentInfo(StudentInfo studentInfo){
        new UpdateAsyncTask(studentDAO).execute(studentInfo);
    }

    public void deleteStudentInfo(StudentInfo studentInfo){
        new DeleteAsyncTask(studentDAO).execute(studentInfo);
    }

    private class InsertAsyncTask extends AsyncTask<StudentInfo, Void, Void> {

        StudentDAO mStudentDAO;

        public InsertAsyncTask(StudentDAO mStudentDAO){
            this.mStudentDAO=mStudentDAO;
        }
        @Override
        protected Void doInBackground(StudentInfo... studentInfos) {
            mStudentDAO.insertStudentInfo(studentInfos[0]);
            return null;
        }
    }

    private class UpdateAsyncTask extends AsyncTask<StudentInfo, Void, Void>{
        StudentDAO mStudentDAO;
        public UpdateAsyncTask(StudentDAO studentDAO) {
            this.mStudentDAO=studentDAO;
        }
        @Override
        protected Void doInBackground(StudentInfo... studentInfos) {
            mStudentDAO.updateStudentInfo(studentInfos[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends AsyncTask<StudentInfo, Void, Void>{
        StudentDAO mStudentDAO;
        public DeleteAsyncTask(StudentDAO studentDAO) {
            this.mStudentDAO=studentDAO;
        }
        @Override
        protected Void doInBackground(StudentInfo... studentInfos) {
            mStudentDAO.deleteStudentInfo(studentInfos[0]);
            return null;
        }
    }
}
