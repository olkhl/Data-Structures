//Chingizkhan Tangirbergenov & Olzhas Sutemgenov
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.adt;

/**
 *
 * @author Chingizkhan Tangirbergenov and Olzhas Sutemgenov
 * @param <T>
 */
public interface Queue<T> {


    /**
     * adds to the end of queue .
     *
     * @param value of element is add to the top of a queue
     */
    public void enqueue(T value);

    /**
     * removes and returns the front most element of queue
     *
     * @return the front most element of queue
     * @throws Exception if queue is empty
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
     * @return a String representation of queue
     */
    @Override
    public String toString();
}
