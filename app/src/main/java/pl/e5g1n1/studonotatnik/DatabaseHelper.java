package pl.e5g1n1.studonotatnik;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(CREATE_SUBJECT_TABLE);
        database.execSQL(CREATE_NOTES_TABLE);

    }

    @Override
    public void onOpen(SQLiteDatabase database)
    {
        super.onOpen(database);
        if(!database.isReadOnly())
        {
            database.execSQL("PRAGMA foreign_keys = ON;");
        }
    }

    @Override
    public void  onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
    {
        database.execSQL("DROP TABLE IF EXISTS " + NotesDbSchema.Subjects.TABLE_NAME);
        database.execSQL("DROP TABLE IF EXISTS " + NotesDbSchema.Notes.TABLE_NAME);
        onCreate(database);
    }


    private static final String DATABASE_NAME = "notes.db";
    private static final int VERSION = 1;
    private static final String CREATE_SUBJECT_TABLE = "CREATE TABLE " + NotesDbSchema.Subjects.TABLE_NAME + "("
            + NotesDbSchema.Subjects.Columns.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NotesDbSchema.Subjects.Columns.NAME + " TEXT, "
            + NotesDbSchema.Subjects.Columns.LECTURER + " TEXT)";

    private static final String CREATE_NOTES_TABLE = "CREATE TABLE " + NotesDbSchema.Notes.TABLE_NAME + "("
            + NotesDbSchema.Notes.Columns.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NotesDbSchema.Notes.Columns.SUBJECT + " TEXT, "
            + NotesDbSchema.Notes.Columns.DATE + " TEXT, "
            + NotesDbSchema.Notes.Columns.NOTE + " TEXT, "
            + "FOREIGN KEY (" + NotesDbSchema.Notes.Columns.SUBJECT + ") " + "REFERENCES " + NotesDbSchema.Subjects.TABLE_NAME + " (" + NotesDbSchema.Subjects.Columns.NAME + "));";
}
