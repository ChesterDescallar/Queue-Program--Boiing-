/**
 *File Name: Queue
 *@version 1.1
 *Created On: 02-03-2019
 *@since 02-03-2019
 *@author Chester Descallar 978050
 *Copyright: No Copyright
 *Purpose: This class for the queue
 *Version History - version 1.0 - downloaded code, version 1.1 - edited code
 */
/**
 *
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).
 * @author you
 *
 */


import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T>
{

    //TODO:  You need some data to store the queue.  Put the attributes here.
    private QueueElement<T> head;
    private QueueElement<T> tail;


    /**
     * Constructs an empty Queue.
     */
    public Queue ()
    {
        //TODO: Write the Queue constructor
        head = tail = null;
        ;
    }

    /**
     * Returns true if the queue is empty
     */
    public boolean isEmpty ()
    {
        //TODO:  Needs to return true when empty and false otherwise
        return ((head == null) && (tail == null));

    }


    /**
     * Returns the element at the head of the queue
     */
    public T peek () throws NoSuchElementException
    {
        //Checks if the queue is empty and throws a NoSuchElementException()
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        //Otherwise returns the head of the Queue
        else
        {

            return head.getElement();
        }

    }

    /**
     * Removes the front element of the queue
     */
    public void dequeue () throws NoSuchElementException
    {
        //Checks if the queue is empty and throws a NoSuchElementException()
        if (isEmpty())
        {
            tail = null;
            throw new NoSuchElementException();

        }
        //Otherwise removes head element of the queue.
        else
        {
            head = head.getNext();
            //If the head is null, the tail is the last element in the list and thus removes that element.
            if (head == null)
            {
                tail = null;
            }

        }
    }

    /**
     * Puts an element on the back of the queue.
     */
    public void enqueue (T element)
    {
        //Creates a new node containing the element with a next reference to null
        QueueElement<T> newNode = new QueueElement<T>(element, null);
        //Checks if the queue is not empty and adds the element to the end of the Queue
        if(!isEmpty())
        {
            tail.setNext(newNode);
            tail = newNode;

        }
        //Otherwise sets the element to be the head and the tail
        else
        {
            tail = newNode;
            head = newNode;
        }

    }

    /**
     * Print the full contents of the queue in order from head to tail.
     */
    public void print ()
    {
        //Checks if the queue is empty and tells the user that it is empty
        if (isEmpty())
        {
            System.out.println("The queue is empty.");
        }
        //Otherwise displays all the nodes in the head
        else
        {
            QueueElement<T> first =  head;
            while (first != null)
            {
                System.out.println(first.getElement());
                first = first.getNext();

            }
        }
    }
}
