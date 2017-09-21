/*
 * Name: Dobreva Iva Yordanova
 * Student ID: 2016147551
 */

public class CircularLinkedList<T>
{
    private Node<T> head;
    private int size;

    /*
     * Constructor for our Circular Linked List
     *
     * Initialize the instance variables to their default values
     */
    public CircularLinkedList()
    {
      size = 0;
      head = null;
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
     *
     * Note: If the list is not empty and you insert at index 0, it should
     *       be inserted before the head and become the new head. However, if
     *       you insert at index |size|, it should be inserted before the head
     *       but should NOT become the new head.
     */
    public void insert(int index, T data)
    {
      if (isEmpty()) {
        insertAtHead(data);
      } else if ( index >= 0 || index <= size ) {
        if (index == 0 ) {
          insertAtHead(data);
        } else if (index == size) {
          insertAtTail(data);
        } else {
          Node<T> el = new Node<T>(data);
          Node<T> prevEl = getElementAtIndex(index-1);

          el.setPrev(prevEl);
          el.setNext(prevEl.getNext());
          prevEl.setNext(el);
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
     * Note: This should work even if the list is empty.
     */
    public void insertAtHead(T data)
    {
      Node<T> el = new Node<T>(data);

      if (!isEmpty()) {
        el.setPrev(head.getPrev());
        el.setNext(head);
        head.setPrev(el);
        el = head;
        size++;
      } else {
        head = el;
        head.setNext(null);
        head.setPrev(null);
        size++;
      }

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
      Node<T> el = new Node<T>(data);

      if( !isEmpty() ) {
        Node<T> tail = head.getPrev();

        if(tail != null ){
          tail.setNext(el);
          el.setPrev(tail);
          el.setNext(head);
          head.setPrev(el);
        } else {
          el.setNext(head);
          el.setPrev(head);
          head.setNext(el);
          head.setPrev(el);
        }
        size++;
      } else {
        insertAtHead(data);
      }
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
      if( !isEmpty() ) {
        Node<T> el = head;
        Node<T> prev, next;

        for(int idx=0; idx < size; idx++) {
          if ( data.equals(el.getData())) {
            if(idx == 0) {
              removeFromHead();
              break;
            } else if(idx == size-1) {
              removeFromTail();
              break;
            }
            prev = el.getPrev();
            next = el.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            size--;
            break;
          }
          el = el.getNext();
        }
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
      if(index >= 0 && index < size) {
        if(index == 0 ) {
          removeFromHead();
          return;
        } else if( index == size-1) {
          removeFromTail();
          return;
        }

        Node<T> el = getElementAtIndex(index);
        Node<T> prev = el.getPrev();
        Node<T> next = el.getNext();

        prev.setNext(next);
        next.setPrev(prev);
        size--;
      }
    }

    /*
     * removeFromHead
     *
     * Remove the head node of the list, if it exists
     */
    public void removeFromHead()
    {
      if (!isEmpty()) {
        Node<T> el = head;
        if (size == 1) {
          head = null;
          size = 0;
          return;
        }

        Node<T> prev = head.getPrev();
        Node<T> next = head.getNext();

        head = next;
        next.setPrev(prev);
        prev.setNext(next);
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
      if (!isEmpty()) {
        if (size == 1) {
          removeFromHead();
        } else {
          Node<T> tail = head.getPrev();
          Node<T> prev = tail.getPrev();
          prev.setNext(head);
          head.setPrev(prev);
          size--;
        }
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

        for(int idx =0; idx < size; idx++) {
          if (data.equals(el.getData())) {
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

        for(int idx=0; idx<size; idx++) {
          if(data.equals(el.getData())) {
            return idx;
          }
          el = el.getNext();
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

      if(index < 0 || index >= getSize()) {
        return null;
      }
      
        Node<T> el = head;

        for(int idx=0; idx<index-1; idx++) {
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
      size = 0;
    }

    /*
     * isEmpty
     *
     * Return whether or not the list is empty
     */
    public boolean isEmpty()
    {
        if ( size == 0 ) {
          return true;
        }
        return false;
    }

    /*
     * getHead
     *
     * Return the head node (possibly null)
     */
    public Node<T> getHead()
    {
        return head;
    }

    /*
     * getSize
     *
     * Return the number of elements in the linked list
     */
    public int getSize()
    {
        return size;
    }

    /*
     * toString
     *
     * Return a string representation of the circular linked list
     *
     * Note: We will not be grading this, it is only for you to be able to
     *       easily display the contents of a list by using something
     *       like "System.out.println(cll);". Remember not to have any printed
     *       output in any of the other methods.
     */
    public String toString()
    {
        Node<T> el = head;
        String ll = "";

        for(int idx =0; idx<size; idx++) {
          ll = ll + " " + el.getData();
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
        private Node<T> prev, next;
        private T data;

        public Node(T data)
        {
            this.data = data;
        }

        public void setNext(Node<T> next)
        {
            this.next = next;
        }

        public void setPrev(Node<T> prev)
        {
            this.prev = prev;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public Node<T> getNext()
        {
            return this.next;
        }

        public Node<T> getPrev()
        {
            return this.prev;
        }

        public T getData()
        {
            return this.data;
        }

        public void clearNext()
        {
            this.next = null;
        }

        public void clearPrev()
        {
            this.prev = null;
        }
    }
}
