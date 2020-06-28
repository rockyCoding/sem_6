/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class Person implements Comparable<Person>
{
   private String nachname;
   private String vorname;
   private String email;
   private String ort;
   private int jahrgang;

   Person(String n, String v, String e, String o, int j)
   {
      nachname = n;
      vorname = v;
      email = e;
      ort = o;
      jahrgang = j;
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
            && ort.equals(p2.ort)
            && jahrgang == p2.jahrgang;
      } else return false;
   }


   @Override
   public int compareTo(Person p)
   {
      if (jahrgang < p.jahrgang) return -1;
      else if (jahrgang > p.jahrgang) return 1;
      else return 0;
   }

   public String toString()
   {
      return nachname + "," + vorname +"(" + jahrgang + ")";
   }
}