/**
 * @author Gianni N. Di Pietro
 * @version 1.0
 */
public class StackTest
{
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<>();

      /* (1) create = s0 */
      /* (2) empty(s0) = true */
        assert stack.empty();
        System.out.println("(1) create = f0: " + stack);
        System.out.println("(2) empty(f0) = true: " + stack.empty());

        String string1 = "aa";
        stack.push(string1);

      /* (3) empty(push(s, x)) = false */
        assert !stack.empty();
        System.out.println("(3) empty(push(s, x)) = false: " + stack.empty());

      /* (4) peek(push(s, x)) = x */
        assert stack.peek().equals(string1);
        System.out.println("(4) peek(push(s, x)) = x: " + stack.peek() + " / " + string1);

        stack.push("bb").push("cc");

      /* (5) pop(push(s, x)) = s */
        String string2 = stack.toString();
        stack.push("xx").pop();
        String string3 = stack.toString();
        assert string2.equals(string3);
        System.out.println("(5) pop(push(s, x)) = s: " + string2 + " / " + string3);
    }
}

