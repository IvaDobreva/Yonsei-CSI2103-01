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

public class LinkedListTest
{
    @Test
    public void testBasic()
    {
      LinkedList<String> ll = new LinkedList<String>();
      LinkedList<String> kk = new LinkedList<String>();
      String x = "Random";

      kk.insertAtHead("Iva");
      kk.insert(1, "Yordanova");
      kk.insert(2, "Dobreva");

      ll.insertAtHead("Data");
      System.out.println(ll.getSize());
      System.out.println(ll.toString());

      ll.removeFromHead();
      System.out.println(ll.getSize());
      System.out.println(ll.toString());

      ll.insertAtTail("Structures");
      System.out.println(ll.getSize());
      System.out.println(ll.toString());

      ll.insert(2, "is the best class");
      System.out.println(ll.getSize());
      System.out.println(ll.toString());

      ll.insertAtHead("Facebook");
      System.out.println(ll.getSize());
      System.out.println(ll.toString());

      ll.insertAtTail("Twitter");
      System.out.println(ll.getSize());
      System.out.println(ll.toString());
      kk.joinLists(ll);
      System.out.println("List2" + kk.toString());

      ll.joinLists(kk);
      System.out.println(ll.toString());
      System.out.println("List2" + kk.toString());
      ll.insert(2, "Random");
      System.out.println(ll.getSize());
      System.out.println(ll.toString());

      System.out.println(ll.contains(x));
      System.out.println(ll.toString());
      ll.remove(x);
      System.out.println(ll.getSize());
      System.out.println(ll.toString());

      ll.removeFromHead();
      System.out.println(ll.getSize());
      System.out.println(ll.toString());

      ll.removeFromTail();
      System.out.println(ll.getSize());
      System.out.println(ll.toString());

      ll.removeIndex(0);
      System.out.println(ll.getSize());
      System.out.println(ll.toString());
      System.out.println(ll.isEmpty());

      ll.clear();
      System.out.println(ll.getSize());
      System.out.println(ll.toString());
      System.out.println(ll.isEmpty());


      ll.insert(0, "Hello");
      System.out.println(ll.getSize());
      System.out.println(ll.toString());
      System.out.println(ll.isEmpty());

    //  assertTrue(ll.contains("Data"));
    //  assertFalse(ll.contains("is the worst class"));
    }
}
