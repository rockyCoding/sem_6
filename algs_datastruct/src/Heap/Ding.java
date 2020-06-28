/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class Ding implements Comparable<Ding>
{
   private int inhalt;

   Ding(int wert)
   {
      inhalt = wert;
   }

   @Override
   public int compareTo(Ding ding)
   {
      if (this.inhalt < ding.inhalt)
         return -1;
      else if (this.inhalt > ding.inhalt)
         return 1;
      else
         return 0;
   }

   public String toString() { return String.valueOf(inhalt); }

}