/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class Stack<T>
{
    private Liste<T> liste;

    Stack()
    {
        liste = new Liste<T>();
    }

    boolean empty()
    {
        return liste.istLeer();
    }

    Stack<T> push(T item)
    {
        liste.fügeEin(item, Liste.Pos.AM_ANFANG);
        return this;
    }

    Stack<T> pop()
    {
        liste.lösche(Liste.Pos.AM_ANFANG);
        return this;
    }

    T peek()
    {
        return liste.setze(Liste.Pos.AM_ANFANG).zeige();
    }

    public String toString()
    {
        return liste.toString();
    }
}