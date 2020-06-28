import java.util.Iterator;

/**
 * @author Gianni N. Di Pietro
 * @version 1.3
 */
public class ListeTest
{

    public static void main(String[] args)
    {
        Liste<String> meineListe = new Liste<>("H");
        System.out.println
        (
            meineListe
                .finde("H").fügeEin("N", Liste.Pos.NACH_CURSOR)
                .finde("N").fügeEin("W", Liste.Pos.NACH_CURSOR)
                .finde("H").fügeEin("F", Liste.Pos.VOR_CURSOR)
                .finde("F").fügeEin("H", Liste.Pos.VOR_CURSOR)
                .finde("F").fügeEin("S", Liste.Pos.VOR_CURSOR)
                .finde("S").fügeEin("L", Liste.Pos.VOR_CURSOR)
                .finde("S").fügeEin("-", Liste.Pos.NACH_CURSOR)
        );

        System.out.println("-- Ausgabe mit Iterator --");
        Iterator<String> it = meineListe.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("-- Ausgabe mit vereinfachter for()-Schleife --");
        for (String str : meineListe)
            System.out.println(str);

        System.out.println
        (
            meineListe
                .finde("S").lösche(Liste.Pos.NACH_CURSOR)
        );
        System.out.println
        (
            meineListe
                .finde("H").lösche(Liste.Pos.BEI_CURSOR)
                .finde("L").lösche(Liste.Pos.BEI_CURSOR)
                .finde("S").lösche(Liste.Pos.BEI_CURSOR)
        );
        System.out.println
        (
            meineListe.setze(Liste.Pos.AM_ENDE).fügeEin("~", Liste.Pos.NACH_CURSOR)
                .setze(Liste.Pos.AM_ANFANG).fügeEin("~", Liste.Pos.VOR_CURSOR)
        );

        System.out.println(meineListe.finde("X").zeige());
        System.out.println(meineListe.setze(Liste.Pos.AM_ANFANG).zeige());
        System.out.println(meineListe.setze(Liste.Pos.AM_ENDE).zeige());

        System.out.println
        (   meineListe.setze(Liste.Pos.AM_ANFANG).lösche(Liste.Pos.BEI_CURSOR)
                .setze(Liste.Pos.AM_ENDE).lösche(Liste.Pos.BEI_CURSOR)
        );
    }
}