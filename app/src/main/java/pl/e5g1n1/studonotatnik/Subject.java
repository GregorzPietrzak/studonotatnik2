package pl.e5g1n1.studonotatnik;

import java.util.ArrayList;


/**
 * Klasa przechowująca dane dotyczące nazwy przedmiotu i danych wykładowcy.
 */
public class Subject
{
    public Subject(int id, String subjectName, String lecturer)
    {
        this.id = id;
        this.subjectName = subjectName;
        if(!lecturer.equals(""))
        {
            this.lecturer = lecturer;
        }
    }
    public Subject(String subjectName, String lecturer)
    {
        this(0, subjectName, lecturer);
    }

    public int getId()
    {
        return id;
    }

    public String getLecturer()
    {
        return lecturer;
    }

    public String getSubjectName()
    {
        return subjectName;
    }

    @Override
    public String toString()
    {
        return subjectName + "|" + lecturer;
    }

    private int id;
    private String subjectName;
    private String lecturer = "brak";
}
