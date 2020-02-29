/**
 * Ein Brett zur Loesung des n-Damen-Problems mittels Backtracking.
 * Die Nummerierung beginnt mit dem Index 1.
 */
public class NDamenBrett
{
    private int nZ;
    private int[] pos;
    private boolean[] zBes;
    private boolean[] d1Bes;
    private boolean[] d2Bes;

    /**
     * Konstruktur, der ein Brett der angegebenen Groesse erzeugt
     * @param zeilen  Anzahl Zeilen (und damit auch Anzahl Spalten) des Bretts
     */
    public NDamenBrett(int zeilen)
    {
        nZ = zeilen;
        pos = new int[nZ + 1];
        zBes = new boolean[nZ + 1];
        d1Bes = new boolean[2 * nZ];
        d2Bes = new boolean[2 * nZ];
    }

    /**
     * Liefert die Groesse des Bretts
     * @return Anzahl Zeilen (und damit auch Anzahl Spalten) des Bretts
     */
    int anzahlZeilen()
    {
        return nZ;
    }

    /**
     * Gibt an, welche Zeile in Spalte s durch eine Dame belegt ist
     * @param s Spalte, die betrachtet wird
     * @return in Spalte s belegte Zeile
     */
    int letzteBelegteZeileInSpalte(int s)
    {
        return pos[s];
    }

    /**
     * Setzt eine Dame auf Spalte s und Zeile z des Bretts
     * @param s Spalte
     * @param z Zeile
     */
    void setzeDameAufPosition(int s, int z)
    {
        this.pos[s] = z;
        zBes[z] = true;
        d1Bes[z + s - 2] = true;
        d2Bes[z - s + (nZ - 1)] = true;
    }

    /**
     * Entfernt die Dame auf Spalte s und Zeile z vom Brett. Ist die Position unbelegt, passiert nichts.
     * @param s Spalte
     * @param z Zeile
     */
    void entferneDameVonPosition(int s, int z)
    {
        this.pos[s] = 0;
        zBes[z] = false;
        d1Bes[z + s - 2] = false;
        d2Bes[z - s + (nZ - 1)] = false;
    }

    /**
     * Gibt an, ob die durch Spalte s und Zeile z definierte Position sicher, d.h. von keiner anderen Dame bedroht ist
     * @param s Spalte
     * @param z Spalte
     * @return wahr, wenn die Position sicher ist, falsch sonst
     */
    boolean istSicherePosition(int s, int z)
    {
        return !zBes[z]
            && !d1Bes[z + s - 2]
            && !d2Bes[z - s + (nZ - 1)];
    }
}
