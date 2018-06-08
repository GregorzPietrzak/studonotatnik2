package pl.e5g1n1.studonotatnik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSubjectActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);
        subjectEditText = findViewById(R.id.subjectTextEdit);
        lecturerEditText = findViewById(R.id.lecturerTextEdit);
        okButton = findViewById(R.id.okButton);
        cancelButton = findViewById(R.id.cancelButton);


        okButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(subjectEditText.getText().toString().equals(""))
                {
                    Toast toast = Toast.makeText(AddSubjectActivity.this, "Podaj nazwę przedmiotu", Toast.LENGTH_LONG);
                    toast.show();
                }
                else
                {
                    Intent intent = new Intent();
                    intent.putExtra(NAME_OF_SUBJECT, subjectEditText.getText().toString().trim());
                    intent.putExtra(NAME_OF_LECTURER, lecturerEditText.getText().toString().trim());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }


    private EditText subjectEditText;
    private EditText lecturerEditText;
    private Button okButton;
    private Button cancelButton;

    public static final String NAME_OF_SUBJECT = "NAME_OF_SUBJECT";
    public static final String NAME_OF_LECTURER = "NAME_OF_LECTURER";
}
