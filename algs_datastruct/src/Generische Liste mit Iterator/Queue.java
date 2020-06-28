/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class Queue<T>
{
    private Liste<T> liste;

    Queue()
    {
        liste = new Liste<T>();
    }

    boolean empty()
    {
        return liste.istLeer();
    }

    Queue<T> enqueue(T item)
    {
        liste.fügeEin(item, Liste.Pos.AM_ENDE);
        return this;
    }

    Queue<T> dequeue()
    {
        liste.lösche(Liste.Pos.AM_ANFANG);
        return this;
    }

    T front()
    {
        return liste.setze(Liste.Pos.AM_ANFANG).zeige();
    }

    public String toString()
    {
        return liste.toString();
    }
}