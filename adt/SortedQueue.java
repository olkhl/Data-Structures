//Chingizkhan Tangirbergenov & Olzhas Sutemgenov
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package csci152.adt;

/**
 * queue only elements which are always in order
 *
 * @param <T>
 */
public interface SortedQueue<T extends Comparable> {

    /**
     * Adds an element to queue in a position which
     * preserves the ordering of elements
     *
     * @author Chingizkhan Tangirbergenov & Olzhas Sutemgenov
     * @param value of element add to the top of a stack
     */
    public void insert(T value);

    /**
     * removes and returns the front most element of queue
     *
     * @return the front most element of queue
     * @throws Exception if the queue is empty
     */
    public T dequeue() throws Exception;

    /**
     * @return size of queue
     */
    public int getSize();

    /**
     * removes all elements from queue
     */
    public void clear();

    /**
     * @return a String representation of the queue
     */
    @Override
    public String toString();
}
