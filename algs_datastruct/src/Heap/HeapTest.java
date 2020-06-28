/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class HeapTest
{
   public static void main(String[] args)
   {
      Heap<Integer> h1 = new Heap<>(1, 2, 5, 9, 3, 6, 7, 19, 10, 8);
      h1.speichere(4).speichere(13);
      System.out.printf("%9s %s\n", "Heap:", h1);
      System.out.printf("%9s %s\n", "Sortiert:", h1.sortiere());

      System.out.println(h1.zeige() + ": " + h1);
      while (!h1.istLeer())
      {
         h1.lösche().lösche();
         System.out.println(h1.zeige() + ": " + h1);
      }

      Heap<Ding> h2 = new Heap<>(new Ding(3), new Ding(2), new Ding(1), new Ding(0));
      System.out.printf("%9s %s\n", "Heap:", h2);
      System.out.printf("%9s %s\n", "Sortiert:", h2.sortiere());

      System.out.println(h2.zeige() + ": " + h2);
      while (!h2.istLeer())
      {
         h2.lösche();
         System.out.println(h2.zeige() + ": " + h2);
      }

      Heap<Person> h3 = new Heap<>
         (
            new Person("Muster", "Adam", "adam.muster@gmx.de", "Muttenz", 1972),
            new Person("Muster", "Berta", "berta@post.ch", "Radolfszell", 1971),
            new Person("Muster", "Christian", "christian.muster@gmx.de", "Muttenz", 1998)
         );
      System.out.printf("%9s %s\n", "Heap:", h3);
      System.out.printf("%9s %s\n", "Sortiert:", h3.sortiere());
   }
}