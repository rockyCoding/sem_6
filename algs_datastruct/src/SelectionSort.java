import java.util.Random;

public class SelectionSort
{
    static void initialisiere(int[] zahlen, int n)
    {
        System.out.println("Initialisiere Array mit " + n + " Zufallselementen");
        Random random = new Random();
        for (int i = 0; i < n; i++)
            zahlen[i] = random.nextInt(1000);
        System.out.println("Initialisierung beendet");
    }

    static void sortiere(int[]zahlen, int n)
    {
        System.out.println("Sortiere Array mit " + n + " Zufallselementen");
        int kleinster, temp;

/* 1 */ for (int i = 0; i < n-1; i++)
        {
/* 2 */     kleinster = i;
/* 3 */     for (int j = i+1; j < n; j++)
            {
/* 4 */         if (zahlen[j] < zahlen[kleinster])
/* 5 */             kleinster = j;
            }
/* 6 */     temp = zahlen[kleinster];
/* 7 */     zahlen[kleinster] = zahlen[i];
/* 8 */     zahlen[i] = temp;
        }

        System.out.println("Sortierung beendet");
    }

    static boolean suche(int[] zahlen, int n, int z)
    {
        int u, v;
        u = 0; v = n-1;
        while (u <= v)
        {
            int m = (u + v) / 2;
            if (z < zahlen[m]) v = m - 1;
            else if (z > zahlen[m]) u = m + 1;
            else return true;
        }
        return false;
    }

    static void gibAus(int[] zahlen, int n)
    {
        System.out.print(" ");
        for (int i = 0; i < n; i++)
        {
            System.out.printf("%3d", zahlen[i]);
            if (i < n - 1) System.out.print(" . ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] zahlen;
        int n = 100;
        if (args.length > 0) n = Integer.parseInt(args[0]);
        zahlen = new int[n];

        initialisiere(zahlen, n);
        gibAus(zahlen, n);
        sortiere(zahlen, n);
        gibAus(zahlen, n);
        for (int i = 0; i < n-1; i++) assert (zahlen[i] <= zahlen[i+1]);
    }
}