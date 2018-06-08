package pl.e5g1n1.studonotatnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        subject = getIntent().getStringExtra(MainActivity.TITLE);

        setTitle(subject);

        addNoteButton = findViewById(R.id.addNoteButton);
        editNoteText = findViewById(R.id.editNewNote);
        notesRecyclerView = findViewById(R.id.notesRecyclerView);

        notesList = new ArrayList<>();
        notesList.add(new SingleNote(1, "Matematyka", "12-05-2018 11:33:21", "Dodawanie nie jest trudne 1+2=3"));
        notesList.add(new SingleNote(2, "Matematyka", "12-05-2018 11:34:04", "Dodawanie nie jest trudne 2+2=4"));
        notesList.add(new SingleNote(3, "Matematyka", "12-05-2018 11:35:00", "Dodawanie nie jest trudne 4+2=6"));

        notesRecyclerView = findViewById(R.id.notesRecyclerView);
        notesRecyclerView.setHasFixedSize(true);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        notesRecyclerView.setAdapter(new NoteListAdapter(notesList));

        addNoteButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                notesList.add(new SingleNote(subject, editNoteText.getText().toString()));
                editNoteText.setText("");
                notesRecyclerView.getAdapter().notifyDataSetChanged();
            }
        });




    }

    private Button addNoteButton;
    private EditText editNoteText;
    private RecyclerView notesRecyclerView;

    private ArrayList<SingleNote> notesList;
    private String subject;

}
