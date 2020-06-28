/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class Person
{
    private String nachname;
    private String vorname;
    private String email;
    private String ort;

    Person(String n, String v, String e, String o)
    {
        nachname = n;
        vorname = v;
        email = e;
        ort = o;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Person)
        {
            Person p2 = (Person) o;
            return nachname.equals(p2.nachname)
                    && vorname.equals(p2.vorname)
                    && email.equals(p2.email)
                    && ort.equals(p2.ort);
        } else return false;
    }

    public String toString()
    {
        return nachname + "," + vorname;
    }
}