package pl.e5g1n1.studonotatnik;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class SubjectListAdapter extends RecyclerView.Adapter<SubjectListAdapter.ViewHolder>
{
    public SubjectListAdapter(ArrayList<Subject> subjectList)
    {
        this.subjectList = subjectList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rowView = layoutInflater.inflate(R.layout.subject_list_element, parent, false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Subject subject = subjectList.get(position);
        holder.subjectTextView.setText(subject.getSubjectName());
        holder.lecturerTextView.setText(subject.getLecturer());
        holder.removeCheckBox.setOnCheckedChangeListener(null);

    }

    @Override
    public int getItemCount()
    {
        return subjectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View itemView)
        {
            super(itemView);
            subjectTextView = itemView.findViewById(R.id.subjectTextView);
            lecturerTextView = itemView.findViewById(R.id.lecturerTextView);
            removeCheckBox = itemView.findViewById(R.id.removeCheckBox);
        }
        public TextView subjectTextView;
        public TextView lecturerTextView;
        public CheckBox removeCheckBox;
    }

    private ArrayList<Subject> subjectList;

}
