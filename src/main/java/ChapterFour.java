import java.util.ArrayList;
import java.util.List;

public class ChapterFour {

    /**
     * Write out a series of equations representing the calculation of N!
     * For example, if the input is 4 the output could be
     * 4! = 4!
     * = 4 * 3!
     * = 4 * 3 * 2!
     * = 4 * 3 * 2 * 1!
     * = 4 * 3 * 2 * 1 * 0!
     * @param n
     * @return
     */
    public static String question1(int n) {
        List<String> outputs = new ArrayList<>();

        if (n > 0) {
            outputs.add(String.format("%d! = %d!", n, n));

            int count = n;
            while (--count >= 0) {
                outputs.add("= " + question1Helper(n, count));
            }
        }

        return String.join("\n", outputs);
    }

    public static String question1Helper(int n, int stop) {
        if (n < stop) {
            return "ERROR";
        } else if (n == stop) {
            return n + "!";
        } else {
            return n + " * " + question1Helper(--n, stop);
        }
    }

    /**
     * Question 2a, define Sum(n) recursively
     * input must be non-negative integer
     * @param n non-negative integer
     * @return
     */
    public static int question3a(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return n;
        } else {
            return n + question3a(--n);
        }
    }

    /**
     * Question 2b, define BiPower(n) recursively
     * input must be non-negative integer
     * @param n non-negative integer
     * @return
     */
    public static int question3b(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 1;
        } else {
            return 2 * question3b(--n);
        }
    }

    /**
     * Question 2c, define TimesFive(n) recursively
     * @param n integer
     * @return
     */
    public static int question3c(int n) {
        return question3cHelper(n, 5);
    }

    private static int question3cHelper(int n, int count) {
        if (count < 1) {
            return -1;
        } else if (count == 1) {
            return n;
        } else {
            return n + question3cHelper(n, --count);
        }
    }

    /**
     * Question 19, write a recursive method to traverse the
     * elements in a linked list
     */
    @FunctionalInterface
    public interface ObjectOperator {
        public void op(Object o);
    }

    public static void question19(LinkNode node, ObjectOperator operator) {
        if (node != null) {
            operator.op(node.getData());
            question19(node.getNext(), operator);
        }
    }
}
