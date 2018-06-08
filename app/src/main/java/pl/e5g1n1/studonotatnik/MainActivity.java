package pl.e5g1n1.studonotatnik;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //operator = new DatabaseOperator(getApplicationContext());
        /*SingleNote note_1 = new SingleNote("Matematyka", "1+2=3");
        SingleNote note_2 = new SingleNote("Matematyka", "3*3=9");
        SingleNote note_3 = new SingleNote("Fizyka", "F=m*a");
        long id1 = operator.insertSingleNote(note_1);
        long id2 = operator.insertSingleNote(note_2);
        long id3 = operator.insertSingleNote(note_3);
        System.out.println(id1);
        System.out.println(id2);
        System.out.println(id3);*/

        list = new ArrayList<>();
        list.add(new Subject("Matematyka", "prof. Jan Kowalski"));
        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);
        subjectRecyclerView = findViewById(R.id.subjectsRecyclerView);
        subjectRecyclerView.setHasFixedSize(true);
        subjectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        subjectRecyclerView.setItemAnimator(new DefaultItemAnimator());
        subjectRecyclerView.setAdapter(new SubjectListAdapter(list));



        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, AddSubjectActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int count = subjectRecyclerView.getChildCount();
                for(int i = count - 1; i >= 0; i--)
                {
                    View view = subjectRecyclerView.getChildAt(i);
                    if(((CheckBox)view.findViewById(R.id.removeCheckBox)).isChecked())
                    {
                        System.out.println(i);
                        list.remove(i);
                        subjectRecyclerView.removeViewAt(i);
                    }
                }
                subjectRecyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        subjectRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, subjectRecyclerView, new RecyclerTouchListener.ClickListener()
        {
            @Override
            public void onClick(View view, int position)
            {

            }

            @Override
            public void onLongClick(View view, int position)
            {
                System.out.println(list.get(position).getSubjectName());
                Intent intent = new Intent(MainActivity.this, NotesActivity.class);
                intent.putExtra("TITLE", list.get(position).getSubjectName());
                startActivity(intent);
            }
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                String subjectName = data.getStringExtra(AddSubjectActivity.NAME_OF_SUBJECT);
                String lecturer = data.getStringExtra(AddSubjectActivity.NAME_OF_LECTURER);
                list.add(new Subject(subjectName, lecturer));
                subjectRecyclerView.getAdapter().notifyDataSetChanged();
            }
            else
            {
                Toast toast = Toast.makeText(MainActivity.this, "Nic nie dodano", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }


    private Button addButton;
    private Button removeButton;
    private RecyclerView subjectRecyclerView;
    private DatabaseOperator operator;
    private ArrayList<Subject> list;

    public static final int REQUEST_CODE = 1;
    public static final String TITLE = "TITLE";

}
