import java.util.Scanner;

public class Coverage
{
   static long ggt(long x, long y)
   {
      if (x == 7777)
      {
         x = x + y;
         y = y - 10;
      }
      if (x == y) return x;
      else if (x > y) return ggt(x-y, y);
      else return ggt(x, y-x);
   }

   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Eingabe x: "); long x = scanner.nextLong();
      System.out.print("Eingabe y: "); long y = scanner.nextLong();
      System.out.printf("GGT(%d, %d): %d\n", x, y, ggt(x,y));
   }
}
