package pl.e5g1n1.studonotatnik;

public class NotesDbSchema
{
    /*public static final class LecturerTable
    {
        public static final String TABLE_NAME = "lecturers";

        public static final class Columns
        {
            public static final String ID = "id_pk";
            public static final String NAME = "name";
            public static final String SURNAME = "surname";
            public static final String DEGREE = "degree";
            public static final String PHONE_NUMBER = "phone_number";
        }
    }*/

    public static final class Subjects
    {
        public static final String TABLE_NAME = "subjects";

        public static final class Columns
        {
            public static final String ID = "_id";
            public static final String NAME = "name";
            public static final String LECTURER = "lecturer";
        }
    }

    public static final class Notes
    {
        public static final String TABLE_NAME = "notes";

        public static final class Columns
        {
            public static final String ID = "_id";
            public static final String SUBJECT = "subject";
            public static final String DATE = "date";
            public static final String NOTE = "note";
        }
    }
}
