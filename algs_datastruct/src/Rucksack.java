public class Rucksack
{
    static int kapazität = 10;  // Rucksackkapazität, änderbar

    static final int Gewicht = 0, Wert = 1;

    static int[][] gegenstände = { {2,6}, {2,3}, {6,5}, {5,4}, {4,6}};  // Jeweils: Gewicht, Wert, erweiterbar
    // static int[][] gegenstände = { {2,6}, {2,7}};  // zum Ausprobieren, z.B. mit Kapazität 3 oder 4
    // static int[][] gegenstände = { {2,6}, {2,3}, {6,5}, {5,4}, {4,6}, {1,7}};  // zum Ausprobieren

    static int n = gegenstände.length;

    static int gegenstand(int nummer, int art) { return gegenstände[nummer-1][art]; }

    /** Rekursive Variante des Rucksackproblems */
    static int rucksack(int i, int restkapazität)
    {
        if (i == n)
            if (restkapazität < gegenstand(i, Gewicht)) return 0;
            else return gegenstand(i, Wert);
        else if (restkapazität < gegenstand(i, Gewicht)) return rucksack(i+1, restkapazität);
        else
            return Math.max(rucksack(i+1, restkapazität),
                    rucksack(i+1, restkapazität - gegenstand(i, Gewicht)) + gegenstand(i, Wert));
    }

    static void ausgabe(int[][] f)
    {
        System.out.print("      ");
        for (int s = 0; s < f[0].length; s++) System.out.printf("  %2d", s);
        System.out.print("\n      ");
        for (int s = 0; s < f[0].length; s++) System.out.print("----");
        System.out.print("\n");
        for (int z = n; z > 1; z--)
        {
            System.out.printf("%3d | ", z);
            for (int s = 0; s < f[0].length; s++) System.out.printf("  %2d", f[idx(z)][s]);
            System.out.printf("    (G:%d, W:%d)\n", gegenstand(z, Gewicht), gegenstand(z, Wert));
        }
    }

    static int idx(int index) { return index-2; }  // Index-Korrektur, da Zählung von 0 weg

    /** Iterative Variante des Rucksackproblems */
    static int rucksack(int kapazität)
    {
        int[][] f = new int[gegenstände.length-1][kapazität+1];

        int gi;
        int wi;
        int resultat;

        // 1. Initialisierung für i = n
      /for (int restkapazität = 0; restkapazität <= kapazität; restkapazität++)
    {
        gi = gegenstand(n, Gewicht);
        wi = gegenstand(n, Wert);
        if (restkapazität < gi)
            f[idx(n)][restkapazität] = 0;
        else
            f[idx(n)][restkapazität] = wi;
    }

        // 2. Rückwärtsberechnung der weiteren Zeilen von f
        for (int i = n-1; i > 1; i--)
            for (int restkapazität = 0; restkapazität <= kapazität; restkapazität++)
            {
                gi = gegenstand(i, Gewicht);
                wi = gegenstand(i, Wert);

                if (restkapazität < gi)
                    f[idx(i)][restkapazität] = f[idx(i)+1][restkapazität];
                else
                    f[idx(i)][restkapazität] = Math.max(f[idx(i)+1][restkapazität], f[idx(i)+1][restkapazität-gi] + wi);
            }

        // 3. Berechnung des Resultats
        gi = gegenstand(1, Gewicht);
        wi = gegenstand(1, Wert);
        if (kapazität < gi)
            resultat = f[idx(2)][kapazität];
        else
            resultat = Math.max(f[idx(2)][kapazität], f[idx(2)][kapazität-gi] + wi);

        ausgabe(f);
        return resultat;
    }

    public static void main(String[] args)
    {
        System.out.println("\nEingepackter Wert (rekursiv): " + rucksack(1, kapazität));
        System.out.println("\nEingepackter Wert (iterativ): " + rucksack(kapazität));
    }
}
