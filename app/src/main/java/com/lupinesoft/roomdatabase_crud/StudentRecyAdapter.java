package com.lupinesoft.roomdatabase_crud;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StudentRecyAdapter extends RecyclerView.Adapter<StudentRecyAdapter.StudentViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context mContext;
    List<StudentInfo> mStudentInfo;

    public StudentRecyAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = layoutInflater.inflate(R.layout.recyview_layout, parent ,false);
        StudentViewHolder viewHolder = new StudentViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int i) {
        if(mStudentInfo!=null){
            StudentInfo studentInfo = mStudentInfo.get(i);
            holder.setData(studentInfo.getSid(), studentInfo.getSname(), studentInfo.getScgpa(), i);
        }else{
            holder.idItemView.setText("No ID!");
            holder.nameItemView.setText("No Name!");
            holder.cgpaItemView.setText("No CGPA!");
        }
    }

    @Override
    public int getItemCount() {
        if(mStudentInfo!=null){
            return mStudentInfo.size();
        }else {
            return 0;
        }
    }

    public void setStudentInfos(List<StudentInfo> studentInfos){
        mStudentInfo = studentInfos;
        notifyDataSetChanged();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView idItemView, nameItemView, cgpaItemView;
        int mPosition;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            idItemView = itemView.findViewById(R.id.recy_stdid_ID);
            nameItemView = itemView.findViewById(R.id.recy_stdname_ID);
            cgpaItemView = itemView.findViewById(R.id.recy_stdcgpa_ID);
        }

        public void setData(String id, String name, String cgpa, int position){
            idItemView.setText(id);
            nameItemView.setText(name);
            cgpaItemView.setText(cgpa);
            mPosition=position;
        }
    }
}
