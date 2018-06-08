package pl.e5g1n1.studonotatnik;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder>
{
    public NoteListAdapter(ArrayList<SingleNote> notesList)
    {
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rowView = layoutInflater.inflate(R.layout.note_list_element, parent, false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        SingleNote singleNote = notesList.get(position);
        holder.dateTextView.setText(singleNote.getDateString());
        holder.noteTextView.setText(singleNote.getNote());


    }

    @Override
    public int getItemCount()
    {
        return notesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View itemView)
        {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            noteTextView = itemView.findViewById(R.id.noteTextView);
            LinearLayout linearLayout = itemView.findViewById(R.id.singleNoteLayout);
            int colorRed = 155 + (int)Math.floor(100 * Math.random());
            int colorGreen = 155 + (int)Math.floor(100 * Math.random());
            int colorBlue = 155 + (int)Math.floor(100 * Math.random());
            int bacgroundColor = Color.rgb(colorRed, colorGreen, colorBlue);
            linearLayout.setBackgroundColor(bacgroundColor);

        }
        public TextView dateTextView;
        public TextView noteTextView;
    }

    private ArrayList<SingleNote> notesList;

}