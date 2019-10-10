/**
 *File Name: QueueElement
 *@version 1.1
 *Created On: 02-03-2019
 *@since 02-03-2019
 *@author Chester Descallar 978050
 *Copyright: No Copyright
 *Purpose: This class is used to construct the queue (subclass of ClosedShape)
 *Version History - version 1.0 - downloaded code, version 1.1 - edited code
 */

/**
 * You must use this class when constructing your Queue.  This class represents a link of the
 * linked list.  Your queue will be composed of these links.
 * @author archam
 *
 */
public class QueueElement<E>
{
    private E e; //the element contained in this linked list
    private QueueElement<E> next; //the next element of the linked list

    public QueueElement (E e, QueueElement<E> n)
    {
        this.e = e;
        this.next = n;
    }

    /**
     * Method to set the element
     */
    public void setElement (E e)
    {
        this.e = e;
    }

    /**
     * Method to set the next linked list element
     */
    public void setNext (QueueElement<E> e)
    {
        this.next = e;
    }

    /**
     * Method to get the element.
     */
    public E getElement ()
    {
        return this.e;
    }

    /**
     * Method to get the next linked list element
     */
    public QueueElement<E> getNext ()
    {
        return this.next;
    }
}
