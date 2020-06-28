import java.util.Iterator;

/**
 * @author Gianni N. Di Pietro
 * @version 1.3
 */
public class Liste<T> implements Iterable<T>
{
    private Zelle<T> anfang;
    private Zelle<T> cursor;

    public Liste()
    {
        anfang = null;
    }

    Liste(T t)
    {
        anfang = new Zelle<>(t);
    }

    public boolean istLeer()
    {
        return anfang == null;
    }

    Liste<T> setze(Pos p)
    {
        cursor = anfang;
        if (cursor != null)
        {
            if (p.equals(Pos.AM_ENDE))
            {
                while (cursor.nächste != null)
                {
                    cursor = cursor.nächste;
                }
            }
        }
        return this;
    }

    Liste<T> setze(int index)
    {
        cursor = anfang;
        if (cursor != null)
            for (int i = 0; i < index && cursor != null; i++)
                cursor = cursor.nächste;
        return this;
    }

    Liste<T> finde(T t)
    {
        if (anfang != null)
        {
            cursor = anfang;
            while (cursor != null && !(cursor.inhalt.equals(t)))
                cursor = cursor.nächste;
        }
        return this;
    }

    T zeige()
    {
        if (cursor != null) return cursor.inhalt;
        else return null;
    }

    public T zeige(int index)
    {
        return setze(index).zeige();
    }

    Liste<T> fügeEin(T t, Pos p)
    {
        assert !p.equals(Pos.BEI_CURSOR) : "Nur VOR_CURSOR, NACH_CURSOR, AM_ANFANG oder AM_ENDE erlaubt";

        if (p.equals(Pos.AM_ANFANG))
        {
            setze(Pos.AM_ANFANG).fügeEin(t, Pos.VOR_CURSOR);
            return this;
        } else if (p.equals(Pos.AM_ENDE))
        {
            setze(Pos.AM_ENDE).fügeEin(t, Pos.NACH_CURSOR);
            return this;
        }

        Zelle<T> z = new Zelle<>(t);

        if (anfang == null)
        {
            anfang = z;
        } else
        {
            if (p.equals(Pos.VOR_CURSOR))
            {
                if (cursor != null)
                {
                    if (cursor == anfang)
                    {
                        z.nächste = anfang;
                        anfang = z;
                    } else
                    {
                        Zelle<T> hilfsCursor = anfang;
                        while (hilfsCursor.nächste != cursor)
                            hilfsCursor = hilfsCursor.nächste;
                        cursor = hilfsCursor;
                        z.nächste = cursor.nächste;
                        cursor.nächste = z;
                    }
                }
            } else if (p.equals(Pos.NACH_CURSOR))
            {
                if (cursor != null)
                {
                    z.nächste = cursor.nächste;
                    cursor.nächste = z;
                }
            }
        }
        return this;
    }

    Liste<T> lösche(Pos p)
    {
        assert !p.equals(Pos.VOR_CURSOR) : "Nur BEI_CURSOR, NACH_CURSOR, AM_ANFANG oder AM_ENDE erlaubt";

        if (p.equals(Pos.AM_ANFANG))
        {
            setze(Pos.AM_ANFANG).lösche(Pos.BEI_CURSOR);
            return this;
        } else if (p.equals(Pos.AM_ENDE))
        {
            setze(Pos.AM_ENDE).lösche(Pos.BEI_CURSOR);
            return this;
        }
        if (p.equals(Pos.BEI_CURSOR))
        {
            if (cursor != null)
            {
                if (cursor == anfang)
                {
                    anfang = anfang.nächste;
                } else
                {
                    Zelle<T> hilfsCursor = anfang;
                    while (hilfsCursor.nächste != cursor)
                        hilfsCursor = hilfsCursor.nächste;
                    cursor = hilfsCursor;
                    cursor.nächste = cursor.nächste.nächste;
                }
            }
        } else if (p.equals(Pos.NACH_CURSOR))
        {
            if (cursor != null && cursor.nächste != null)
            {
                cursor.nächste = cursor.nächste.nächste;
            }
        }
        return this;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        cursor = anfang;
        sb.append("[ ");
        while (cursor != null)
        {
            sb.append(cursor.inhalt);
            sb.append(' ');
            cursor = cursor.nächste;
        }
        sb.append(']');
        return sb.toString();
    }

    public Iterator<T> iterator()
    {
        return new Cursor();
    }

    private class Cursor implements Iterator<T>
    {
        private Zelle<T> iCursor;

        Cursor()
        {
            iCursor = anfang;
        }

        @Override
        public boolean hasNext()
        {
            return anfang != null && iCursor != null;
        }

        @Override
        public T next()
        {
            T t = iCursor.inhalt;
            iCursor = iCursor.nächste;
            return t;
        }
    }

    private class Zelle<R>
    {
        R inhalt;
        Zelle<R> nächste;

        Zelle(R t)
        {
            inhalt = t;
            nächste = null;
        }

        public String toString()
        {
            return inhalt.toString();
        }
    }

    public enum Pos
    {
        AM_ANFANG, AM_ENDE, VOR_CURSOR, BEI_CURSOR, NACH_CURSOR
    }
}