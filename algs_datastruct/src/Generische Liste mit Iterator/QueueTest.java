/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class QueueTest
{
    public static void main(String[] args)
    {
        Queue<String> queue = new Queue<>();

      /* (1) create = f0 */
      /* (2) empty(f0) = true */
        assert queue.empty();
        System.out.println("(1) create = f0: " + queue);
        System.out.println("(2) empty(f0) = true: " + queue.empty());

        String string1 = "aa";
        queue.enqueue(string1);

      /* (3) empty(enqueue(f, x)) = false */
        assert !queue.empty();
        System.out.println("(3) empty(enqueue(f, x)) = false: " + queue.empty());

      /* (4) front(enqueue(f0, x)) = x */
        assert queue.front().equals(string1);
        System.out.println("(4) front(enqueue(f0, x)) = x: " + queue.front() + " / " + string1);

      /* (6) dequeue(enqueue(f0, x)) = f0 */
        assert queue.dequeue().empty();
        System.out.println("(6) dequeue(enqueue(f0, x)) = f0: " + queue);

        queue.enqueue("bb").enqueue("cc").enqueue("dd");

      /* (5) not empty(f) => front(enqueue(f, x)) = front(f) */
        String string2 = queue.front();
        queue.enqueue("ee");
        String string3 = queue.front();
        assert string2.equals(string3);
        System.out.println("(5) not empty(f) => front(enqueue(f, x)) = front(f): " + string3 + " / " + string2);

      /* (7) not empty(f) => dequeue(enqueue(f, x)) = enqueue(dequeue(f), x) */
        Queue<String> q1 = new Queue<>();
        q1.enqueue("xx").enqueue("yy").enqueue("zz");
        Queue<String> q2 = new Queue<>();
        q2.enqueue("xx").enqueue("yy").enqueue("zz");
        String string4 = q2.enqueue("rr").dequeue().toString();
        String string5 = q1.dequeue().enqueue("rr").toString();
        assert string4.equals(string5);
        System.out.println("(7) not empty(f) => dequeue(enqueue(f, x)) = enqueue(dequeue(f), x): " + q1 + "/" + q2);
    }
}