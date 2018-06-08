package pl.e5g1n1.studonotatnik;

public class Lecturer
{
    public Lecturer(String name, String surname, String degree, String phoneNumber)
    {
        this.name = name;
        this.surname = surname;
        this.degree = degree;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getDegree()
    {
        return degree;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public boolean isEmpty()
    {
        return name.equals("") && surname.equals("") && degree.equals("") && phoneNumber.equals("");
    }

    private int lecturerId;
    private String name;
    private String surname;
    private String degree;
    private String phoneNumber;
}
