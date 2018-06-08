package pl.e5g1n1.studonotatnik;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


/**
 * Klasa opisująca i pozwalająca na tworzenie obiektów będących pojedynczą notatką.
 * Stworzone obiekty będą zawierały informacje w postaci pól typu <tt>String</tt> o przedmiocie,
 * dacie utworzenia notatki oraz teści stworzonej notatki
 *
 * @see <a href="https://developer.android.com/reference/java/lang/String">String</a>
 */
public class SingleNote
{


    /**
     * Tworzy obiekt pojedynczej notatki i inicjuje watrości:
     *
     * @param id         identyfikator
     * @param subject    nazwa przedmiotu
     * @param dateString data dodania notatki
     * @param note       treść notatki
     *                   konstruktor wykorzystywany podczas tworzenia notatki z danych zaczytanych z pliku z
     *                   przechowywanymi wpisami
     * @see <a href="https://developer.android.com/reference/java/lang/String">String</a>
     */
    public SingleNote(int id, String subject, String dateString, String note)
    {
        this.id = id;
        this.subject = subject;
        this.dateString = dateString;
        this.note = note;
    }

    /**
     * Tworzy obiekt pojedynczej notatki i inicjuje wartości:
     *
     * @param subject nazwa przedmiotu
     * @param note    treść notatki
     *                konstruktor wykorzystywany w momencie stworzenia nowej notatki przez użytkownika aplikacji
     *                data utworzenia notatki jest przypisywana automatycznie na podstawie czasu systemowego
     *                format zapisu daty wyglada następująco <tt>dd-MM-yyyy HH:mm:ss</tt> na przykład <tt>24-04-2018 14:24:34</tt>
     * @see <a href="https://developer.android.com/reference/java/lang/String">String</a>
     */
    public SingleNote(String subject, String note)
    {
        this.id = 0;
        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateFormat.setCalendar(date);
        this.subject = subject;
        this.dateString = dateFormat.format(date.getTime());
        this.note = note;
    }

    /**
     * Zwaraca wartość identyfikatora
     *
     * @return identyfikator
     */
    public int getId()
    {
        return id;
    }

    /**
     * Pobiera nazwę przedmiotu
     *
     * @return nazwa przedmiotu
     * @see <a href="https://developer.android.com/reference/java/lang/String">String</a>
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * Pobiera datę utworzenia notatki w postaci napisu
     *
     * @return data utworzenia notatki
     * @see <a href="https://developer.android.com/reference/java/lang/String">String</a>
     */
    public String getDateString()
    {
        return dateString;
    }

    /**
     * Pobiera treść pojedynczej notatki
     *
     * @return treść notatki
     * @see <a href="https://developer.android.com/reference/java/lang/String">String</a>
     */
    public String getNote()
    {
        return note;
    }

    /**
     * Przekształca całość notatki na obiekt typu <tt>String</tt>
     * @return przedmiot|data utworzenia notatki|treść notatki
     * @see <a href="https://developer.android.com/reference/java/lang/String">String</a>
     */
    @Override
    public String toString()
    {
        return subject + "|" + dateString + "|" + note;
    }

    private int id;
    private String subject;
    private String dateString;
    private String note;

}
