import java.util.Random;
import java.util.Scanner;

public class BubbleSort
{
    static final int ITERATIONEN = 20;
    static int[][] vergleiche = new int[ITERATIONEN][2];
    static int iteration;

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
        boolean sortiert;
        do
        {
            sortiert = true;
            for (int i = 0; i < n-1; i++)
            {
                if (zahlen[i] > zahlen[i+1])
                {
                    sortiert = false;
                    int puffer = zahlen[i];
                    zahlen[i] = zahlen[i+1];
                    zahlen[i+1] = puffer;
                }
            }
        } while (!sortiert);
        System.out.println("Sortierung beendet");
    }

    static boolean suche_linear(int[] zahlen, int n, int z)
    {
        for (int i = 0; i < n; i++)
        {
            vergleiche[iteration][0]++;
            if (zahlen[i] == z) return true;
        }
        return false;
    }

    static boolean suche_binaer(int[] zahlen, int n, int z)
    {
        int u, v;
        u = 0; v = n-1;
        while (u <= v)
        {
            int m = (u + v) / 2;
            vergleiche[iteration][1]++;
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
            System.out.print(zahlen[i]);
            if (i < n - 1) System.out.print(" . ");
        }
        System.out.println();

    }

    static void statistik()
    {
        int durchschnitt_linear = 0;
        int durchschnitt_binaer = 0;
        for (int i = 0; i < ITERATIONEN; i++)
        {
            System.out.println(
               String.format("%3d", i + 1) + ": " +
                  String.format("%5d", vergleiche[i][0]) + " / " +
                  String.format("%3d", vergleiche[i][1]));

            durchschnitt_linear += vergleiche[i][0];
            durchschnitt_binaer += vergleiche[i][1];
        }
        System.out.println("Durchschnitt linear: " + durchschnitt_linear/ITERATIONEN);
        System.out.println("Durchschnitt binaer: " + durchschnitt_binaer/ITERATIONEN);
    }

    public static void main(String[] args)
    {
        int[] zahlen;
        int n = 100;
        if (args.length > 0) n = Integer.parseInt(args[0]);
        zahlen = new int[n];

        Scanner scanner = new Scanner(System.in);

        System.out.print("Zu suchende Zahl: ");
        int z = scanner.nextInt();

        for (iteration = 0; iteration < ITERATIONEN; iteration++)
        {
            initialisiere(zahlen, n);
            //gibAus(zahlen, n);
            System.out.println(suche_linear(zahlen, n, z) ? "gefunden" : "nicht gefunden");

            sortiere(zahlen, n);

            //gibAus(zahlen, n);
            System.out.println(suche_binaer(zahlen, n, z) ? "gefunden" : "nicht gefunden");
        }
        statistik();
    }
}
