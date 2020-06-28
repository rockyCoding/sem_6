/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class PersonTest
{
    public static void main(String[] args)
    {
        Person p1 = new Person("Muster", "Adam", "adam.muster@gmx.de", "Muttenz");
        Person p2 = new Person("Muster", "Berta", "berta@post.ch", "Radolfszell");
        Person p3 = new Person("Muster", "Christian", "christian.muster@gmx.de", "Muttenz");

        Person person = new Person("Muster", "Berta", "berta@post.ch", "Radolfszell");

        Liste<Person> meineListe = new Liste<>();
        meineListe
                .setze(Liste.Pos.AM_ANFANG)
                .fügeEin(p2, Liste.Pos.VOR_CURSOR)
                .finde(person)
                .fügeEin(p1, Liste.Pos.VOR_CURSOR)
                .finde(person)
                .fügeEin(p3, Liste.Pos.NACH_CURSOR);

        System.out.println(meineListe);
    }
}