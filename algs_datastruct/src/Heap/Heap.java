import java.util.ArrayList;
import java.util.List;

/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class Heap<T extends Comparable<T>>
{
   @FunctionalInterface
   private interface Verwandtschaft { int von(int i); }

   private Verwandtschaft vater = x -> x/2;
   private Verwandtschaft linkerSohn = x -> x*2;
   private Verwandtschaft rechterSohn = x -> x*2 + 1;

   private ArrayList<T> array;
   private int anzahlEinträge;


   Heap()
   {
      array = new ArrayList<>();
      array.add(null);
   }

   Heap(int n)
   {
      array = new ArrayList<>(n+1);
      array.add(null);
   }

   Heap(T... werte)
   {
      this(werte.length+1);
      for (T w : werte) speichere(w);
      anzahlEinträge = array.size()-1;
   }

   Heap (Heap<T> original)
   {
      array = (ArrayList<T>) original.array.clone();
      anzahlEinträge = original.anzahlEinträge;
   }


   private boolean istKleiner(int i1, int i2) { return array.get(i1).compareTo(array.get(i2)) < 0; }

   private boolean istGrösser(int i1, int i2) { return array.get(i1).compareTo(array.get(i2)) > 0; }

   private int indexDesKleineren(int i1, int i2)
   {
      if (i1 > anzahlEinträge) return 0;        // kein linker Sohn vorhanden
      else if (i2 > anzahlEinträge) return i1;  // kein rechter Sohn vorhanden
      else if (istKleiner(i1, i2)) return i1;   // linker Sohn kleiner als rechter
      else return i2;                           // rechter Sohn kleiner als linker
   }

   private void tausche(int i1, int i2)
   {
      T tmp = array.get(i1);
      array.set(i1, array.get(i2));
      array.set(i2, tmp);
   }

   private void siftUp()
   {
      int i = anzahlEinträge;
      int vi = vater.von(i);

      while (vi > 0 && istKleiner(i, vi))
      {
         tausche(i, vi);
         i = vi;
         vi = vater.von(i);
      }
   }

   private void siftDown(int ab, int bis)
   {
      int i = ab;
      int imin;

      imin = indexDesKleineren(linkerSohn.von(i), rechterSohn.von(i));
      if (imin == 0) return;

      while (imin <= bis && istGrösser(i, imin))
      {
         tausche(i, imin);
         i = imin;

         imin = indexDesKleineren(linkerSohn.von(i), rechterSohn.von(i));
         if (imin == 0) return;
      }
   }

   List<T> sortiere()
   {
      Heap<T> geklonterHeap = new Heap<>(this);

      for (int i = geklonterHeap.anzahlEinträge; i > 1; i--)
      {
         geklonterHeap.tausche(1, i);
         geklonterHeap.anzahlEinträge--;

         geklonterHeap.siftDown(1, i-1);
      }
      return geklonterHeap.array.subList(1, array.size());
   }

   Heap<T> speichere(T t)
   {
      array.add(t);  // Element zuunterst anhängen
      anzahlEinträge++;

      siftUp();

      return this;
   }

   Heap<T> lösche()
   {
      if (!istLeer())
      {
         array.set(1, array.get(anzahlEinträge));  // unterstes Element in die Wurzel befördern
         array.remove(anzahlEinträge);             // und unterstes Element löschen
         anzahlEinträge--;

         siftDown(1, anzahlEinträge);
      }
      return this;
   }

   T zeige()
   {
      if (!istLeer()) return array.get(1);
      else return null;
   }

   boolean istLeer()
   {
      return array == null || array.size() <= 1;
   }

   @Override
   public String toString()
   {
      return array.subList(1, array.size()).toString();
   }
}
