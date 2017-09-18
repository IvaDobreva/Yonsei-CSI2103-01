/*
 * Name: Dobreva Iva Yordanova
 * Student ID: 2016147551
 */

/*
 * You should not import anything or change/add any instance variables, methods,
 * or method signatures.
 */
public class LinkedList<T>
{

    private int size;
    private Node<T> head, tail;

    /*
     * Constructor for our Linked List
     *
     * Initialize the instance variables to their default values
     */
    public LinkedList()
    {
      head = null;
      tail = null;
      size = 0;
    }

    /*
     * insert
     *
     * Insert a new node with the specified data into the specified index
     *
     * index - int; the location in which to insert the new node (indexed
     *              from 0)
     *
     * data - T; the data to be stored in the newly created node
     *
     * Note:  If the index is out of range ([0, size]), nothing should be
     *        inserted.
     */
    public void insert(int index, T data)
    {
      if(index>=0 && index <= (size) ) {
        if(index == 0 ) {
          insertAtHead(data);
        } else if (index == (size) ) {
          insertAtTail(data);
        } else {
          Node<T> newElement = new Node<T>(data);
          Node<T> previous;

          previous = getElementAtIndex(index-1);
          newElement.setNext(previous.getNext());
          previous.setNext(newElement);
          size++;
        }
      }
    }

    /*
     * insertAtHead
     *
     * Insert a new node at the head with the specified data
     *
     * data - T; the data to be stored in the newly created node
     *
     * Note: This should insert even if the list is empty.
     */
    public void insertAtHead(T data)
    {
      Node<T> newElement = new Node<T>(data);
      if(!isEmpty()) {
        newElement.setNext(head);
      } else {
        // When the list is empty head and tail will be overlapping
        tail = newElement;
        newElement.setNext(null);
      }

      head = newElement;
      size++;
    }

    /*
     * insertAtTail
     *
     * Insert a new node at the tail with the specified data
     *
     * data - T; the data to be stored in the newly created node
     *
     * Note: This should insert even if the list is empty.
     */
    public void insertAtTail(T data)
    {
      Node<T> newElement = new Node<T>(data);
      newElement.setNext(null);

      if ( !isEmpty() ) {
        tail.setNext(newElement);
      } else {
        // If the list is empty head and tail are overlapping
        head = newElement;
      }

      tail = newElement;
      size++;
    }

    /*
     * remove
     *
     * Remove the first node with the specified data, if it exists
     *
     * data - T; the data to find and remove from the list
     *
     * Note: You should use x.equals(y) to compare generic data
     */
    public void remove(T data)
    {
      Node<T> el = head;
      int idx = 0;

      while (el != null ) {
        if(data.equals(el.getData())) {
          removeIndex(idx);
        }
        idx++;
        el = el.getNext();
      }
    }

    /*
     * removeIndex
     *
     * Remove the node at the specified index
     *
     * index - int; the index to remove from
     *
     * Note: If the index is out of range do nothing
     */
    public void removeIndex(int index)
    {
      if(index >= 0 && index < size ) {
        if (index == 0 ) {
          removeFromHead();
        } else if (index == (size-1)) {
          removeFromTail();
        } else {
          Node<T> element = getElementAtIndex(index);
          Node<T> previous = getElementAtIndex(index-1);
          previous.setNext(element.getNext());
          size--;
        }
      }
    }

    /*
     * removeFromHead
     *
     * Remove the head node of the list, if it exists
     */
    public void removeFromHead()
    {
      if( !isEmpty() ) {
        Node<T> nextEl;
        nextEl = head.getNext();
        head = nextEl;
        size--;
      }
    }

    /*
     * removeFromTail
     *
     * Remove the tail node of the list, if it exists
     */
    public void removeFromTail()
    {
      if( !isEmpty() ) {
        Node<T> previous;
        previous = getElementAtIndex(size-2);
        previous.setNext(null);
        tail = previous;
        size--;
      }
    }

    /*
     * joinLists
     *
     * Append a second list to the current list
     *
     * ll - LinkedList<T>; the linked list to append to the current list
     *
     * Note: This should work even if one or both of the lists are empty
     */
    public void joinLists(LinkedList<T> ll)
    {
      Node<T> el = ll.getHead();
      while(el != null ) {
        insertAtTail(el.getData());
        el = el.getNext();
      }
    }

    /*
     * contains
     *
     * Check to see if the list contains a node with the specified data
     *
     * data - T; the data to check for
     *
     * Note: You should use x.equals(y) to compare generic data
     */
    public boolean contains(T data)
    {
        Node<T> el = head;
        while (el != null) {
          if( data.equals(el.getData()) ) {
            return true;
          }
          el = el.getNext();
        }
        return false;
    }

    /*
     * getIndex
     *
     * Return the index of the first node in the list with the specified data
     * or -1 if it does not exist
     *
     * data - T; the data to check for
     *
     * Note: You should use x.equals(y) to compare generic data
     */
    public int getIndex(T data)
    {
      Node<T> el = head;
      int idx = 0;

      while (el != null ) {
        if( data.equals(el.getData()) ) {
          return idx;
        }
        el = el.getNext();
        idx++;
      }

        return -1;
    }

    /*
     * getElementAtIndex
     *
     * Return the node at the specified index or null if it is out of range
     *
     * index - int; the desired index
     */
    public Node<T> getElementAtIndex(int index)
    {
        if(index <0 || index>=size ) {
          return null;
        }

        Node<T> el;
        el = head;
        for(int idx=1; idx <= index; idx++) {
          el = el.getNext();
        }

        return el;
    }

    /*
     * clear
     *
     * Clear the linked list
     */
    public void clear()
    {
      head = null;
      tail = null;
      size = 0;
    }

    /*
     * isEmpty
     *
     * Return whether or not the list is empty
     */
    public boolean isEmpty()
    {
        if (size == 0 ) {
          return true;
        }
        return false;
    }

    /*
     * ad
     *
     * Return the head node (possibly null)
     */
    public Node<T> getHead()
    {
      return head;
    }

    /*
     * getTail
     *
     * Return the tail node (possibly null)
     */
    public Node<T> getTail()
    {
        return tail;
    }

    /*
     * getSize
     *
     * Return the number of elements in the linked list
     */
    public int getSize()
    {
        return this.size;
    }

    /*
     * toString
     *
     * Return a string representation of the linked list
     *
     * Note: We will not be grading this, it is only for you to be able to
     *       easily display the contents of a linked list by using something
     *       like "System.out.println(ll);". Remember not to have any printed
     *       output in any of the other methods.
     */
    public String toString()
    {
        String ll = "";
        Node<T> el = head;

        while (el != null ) {
          ll = ll + ' ' + el.getData();
          el = el.getNext();
        }

        return ll;
    }

    /*
     * Node<T> class
     *
     * This class describes a generic node object.
     *
     * You should not edit anything below this line but please note exactly what
     * is implemented so that you can use it in your linked list code
     */
    public class Node<T>
    {
        private Node<T> next;
        private T data;

        public Node(T data)
        {
            this.data = data;
        }

        public void setNext(Node<T> next)
        {
            this.next = next;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public Node<T> getNext()
        {
            return this.next;
        }

        public T getData()
        {
            return this.data;
        }

        public void clearNext()
        {
            this.next = null;
        }
    }
}
