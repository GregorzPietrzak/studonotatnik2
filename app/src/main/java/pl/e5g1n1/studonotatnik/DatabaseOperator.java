package pl.e5g1n1.studonotatnik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DatabaseOperator
{
    public DatabaseOperator(Context context)
    {
        this.database = new DatabaseHelper(context).getWritableDatabase();
    }

    public long insertSubject(Subject subject)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesDbSchema.Subjects.Columns.NAME, subject.getSubjectName());
        contentValues.put(NotesDbSchema.Subjects.Columns.LECTURER, subject.getLecturer());

        return database.insert(NotesDbSchema.Subjects.TABLE_NAME, null, contentValues);
    }

    public ArrayList<Subject> getAllSubjects()
    {
        ArrayList<Subject> subjects = new ArrayList<>();
        String query = "SELECT * FROM " + NotesDbSchema.Subjects.TABLE_NAME;
        Cursor cursor = database.rawQuery(query, null);
        System.out.println(cursor.getCount());
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(NotesDbSchema.Subjects.Columns.ID));
            String subjectName = cursor.getString(cursor.getColumnIndex(NotesDbSchema.Subjects.Columns.NAME));
            String  lecturer = cursor.getString(cursor.getColumnIndex(NotesDbSchema.Subjects.Columns.LECTURER));
            subjects.add(new Subject(id, subjectName, lecturer));

        }
        cursor.close();
        return subjects;
    }
    public int updateSubject(Subject subject)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesDbSchema.Subjects.Columns.NAME, subject.getSubjectName());
        contentValues.put(NotesDbSchema.Subjects.Columns.LECTURER, subject.getLecturer());

        return database.update(NotesDbSchema.Subjects.TABLE_NAME, contentValues, NotesDbSchema.Subjects.Columns.ID + " =?", new String[]{String.valueOf(subject.getId())});
    }

    public long insertSingleNote(SingleNote singleNote)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesDbSchema.Notes.Columns.SUBJECT, singleNote.getSubject());
        contentValues.put(NotesDbSchema.Notes.Columns.DATE, singleNote.getDateString());
        contentValues.put(NotesDbSchema.Notes.Columns.NOTE, singleNote.getNote());

        return database.insert(NotesDbSchema.Notes.TABLE_NAME, null, contentValues);
    }


    public ArrayList<SingleNote> getAllNotes()
    {
        ArrayList<SingleNote> notes = new ArrayList<>();
        String query = "SELECT * FROM " + NotesDbSchema.Notes.TABLE_NAME;
        Cursor cursor = database.rawQuery(query, null);
        System.out.println(cursor.getCount());

        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(NotesDbSchema.Notes.Columns.ID));
            String subjectName = cursor.getString(cursor.getColumnIndex(NotesDbSchema.Notes.Columns.SUBJECT));
            String date = cursor.getString(cursor.getColumnIndex(NotesDbSchema.Notes.Columns.DATE));
            String note = cursor.getString(cursor.getColumnIndex(NotesDbSchema.Notes.Columns.NOTE));
            notes.add(new SingleNote(id, subjectName, date, note));
        }
        cursor.close();
        return notes;
    }

    public ArrayList<SingleNote> getNotesBySubject(Subject subject)
    {
        ArrayList<SingleNote> notes = new ArrayList<>();
        String query = "SELECT * FROM " + NotesDbSchema.Notes.TABLE_NAME + "WHERE " + NotesDbSchema.Notes.Columns.SUBJECT + " = " + subject.getSubjectName();
        Cursor cursor = database.rawQuery(query, null);
        System.out.println(cursor.getCount());

        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(NotesDbSchema.Notes.Columns.ID));
            String subjectName = cursor.getString(cursor.getColumnIndex(NotesDbSchema.Notes.Columns.SUBJECT));
            String date = cursor.getString(cursor.getColumnIndex(NotesDbSchema.Notes.Columns.DATE));
            String note = cursor.getString(cursor.getColumnIndex(NotesDbSchema.Notes.Columns.NOTE));
            notes.add(new SingleNote(id, subjectName, date, note));
        }
        cursor.close();
        return notes;
    }

    public int updateSingleNote(SingleNote singleNote)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesDbSchema.Notes.Columns.NOTE, singleNote.getNote());

        return database.update(NotesDbSchema.Notes.TABLE_NAME, contentValues, NotesDbSchema.Notes.Columns.ID + " =?", new String[]{String.valueOf(singleNote.getId())});
    }

    public void closeDatatbase(){
        if(database != null && database.isOpen())
        {
            database.close();
        }
    }
    private SQLiteDatabase database;
    /*public DatabaseOperator()
    {
        subjectList = new ArrayList<>();
        singleNoteList = new ArrayList<>();
    }

    public boolean addSingleNote(SingleNote singleNote)
    {
        return this.singleNoteList.add(singleNote);
    }

    public boolean removeSingleNote(int index)
    {
        if (singleNoteList.size() > index && index > 0)
        {
            singleNoteList.remove(index);
            return true;
        } else
        {
            return false;
        }
    }

    public void removeSubjectNotes(String subject)
    {
        for (int i = singleNoteList.size() - 1; i >= 0; i--)
        {
            if (singleNoteList.get(i).getSubject().toLowerCase().equals(subject.toLowerCase()))
            {
                singleNoteList.remove(i);
            }
        }
    }

    public ArrayList<SingleNote> getSubjectNotes(String subject)
    {
        ArrayList<SingleNote> list = new ArrayList<>();
        for (SingleNote singleNote : singleNoteList)
        {
            if (singleNote.getSubject().toLowerCase().equals(subject.toLowerCase()))
            {
                list.add(singleNote);
            }
        }
        return list;
    }

    public void doAtOpen(Context context)
    {
        File file = context.getFilesDir();

    }
    private static final String NOTES_FILE_NAME = "notes";
    private static final String SUBJECT_FILE_NAME = "subject";
    private ArrayList<String> subjectList;
    private ArrayList<SingleNote> singleNoteList;*/
}
