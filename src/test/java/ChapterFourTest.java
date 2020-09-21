import junit.framework.TestCase;

import java.util.concurrent.atomic.AtomicInteger;

public class ChapterFourTest extends TestCase {

    public void testQuestion1() {
        String factorial = ChapterFour.question1(4);
        assertEquals("4! = 4!\n= 4 * 3!\n= 4 * 3 * 2!\n= 4 * 3 * 2 * 1!\n= 4 * 3 * 2 * 1 * 0!", factorial);
    }

    public void testQuestion3a() {
        assertEquals(0, ChapterFour.question3a(0));
        assertEquals(4 + 3 + 2 + 1, ChapterFour.question3a(4));
        assertEquals(5 + 4 + 3 + 2 + 1, ChapterFour.question3a(5));
    }

    public void testQuestion3b() {
        assertEquals(1, ChapterFour.question3b(0));
        assertEquals(32, ChapterFour.question3b(5));
        assertEquals(64, ChapterFour.question3b(6));
        assertEquals(128, ChapterFour.question3b(7));
    }

    public void testQuestion3c() {
        assertEquals(0, ChapterFour.question3c(0));
        assertEquals(10, ChapterFour.question3c(2));
        assertEquals(25, ChapterFour.question3c(5));
        assertEquals(100, ChapterFour.question3c(20));
    }

    public void testQuestion19() {
        LinkedList<String> list = new LinkedList<>();
        list.insert("1");
        list.insert("2");
        list.insert("3");

        ChapterFour.question19(list.getFront(), (o -> System.out.println(o)));

        AtomicInteger i = new AtomicInteger();
        ChapterFour.question19(list.getFront(), (o -> i.addAndGet(Integer.parseInt(o.toString()))));
        assertEquals(6, i.get());
    }
}