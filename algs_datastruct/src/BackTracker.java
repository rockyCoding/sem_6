import java.util.ArrayList;

/**
 * Loesung des n-Damen-Problems mittels Backtracking
 */
public class BackTracker
{
   static NDamenBrett brett;

   static boolean versucheSpalte(int spalte)
    {
        boolean erfolg;
        int zeile = 0;

        do
        {
            zeile++;
            erfolg = false;
            for (int i = 0; i < spalte; i++) {
                System.out.println(brett.letzteBelegteZeileInSpalte(i));
            }
            if (brett.istSicherePosition(spalte, zeile))
            {
                brett.setzeDameAufPosition(spalte, zeile); // zeichne Kandidaten auf
                if (spalte < brett.anzahlZeilen())
                {
                    erfolg = versucheSpalte(spalte+1); // versuche nächsten Schritt
                    if (!erfolg){
                        brett.entferneDameVonPosition(spalte, zeile);// lösche Aufzeichnung des Kandidaten
                    }
                } else
                {
                    erfolg = true;
                }
            }
        } while (!erfolg && zeile != brett.anzahlZeilen());
        return erfolg;
    }


    public static void main(String[] args)
    {
       int brettGrösse;
       if (args.length > 0) brettGrösse = Integer.parseInt(args[0]);
       else brettGrösse = 8;

       brett = new NDamenBrett(brettGrösse);
       if (versucheSpalte(1))
       {
          for (int s = 1; s <= brett.anzahlZeilen(); s++)
             System.out.printf("%3d", brett.letzteBelegteZeileInSpalte(s));
          System.out.println();
       } else System.out.println("Keine Lösung");
    }
}
