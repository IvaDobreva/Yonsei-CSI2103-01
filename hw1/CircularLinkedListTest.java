/*
 * Feel free to add your own tests here.
 *
 * You can find a tutorial on junit at
 *     https://www.tutorialspoint.com/junit/index.htm
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.AfterClass;

public class CircularLinkedListTest
{
    @Test
    public void testBasic()
    {
        CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>();
        System.out.println("Iva");

        cll.insertAtHead(3);
        cll.insertAtTail(-1);
      //  cll.removeFromHead();
        System.out.println(cll.toString());
        System.out.println(cll.getSize());
        cll.insert(2, 500);
        System.out.println(cll.toString());
        System.out.println(cll.getSize());

        cll.removeFromTail();
        System.out.println(cll.toString());
        System.out.println(cll.getSize());

      //  System.out.println(cll.getHead().getData());
        assertTrue(cll.contains(-1));
        assertFalse(cll.contains(0));
    }
}
