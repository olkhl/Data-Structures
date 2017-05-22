//Chingizkhan Tangirbergenov & Olzhas Sutemgenov
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.adt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chingizkhan Tangirbergenov and Olzhas Sutemgenov
 * @param <T>
 */
public interface Stack<T> {

    /**
     * adding to the end of a stack the element.
     *
     * @param value of element add to the top of a stack 
     */
    public void push(T value);

    /**
     * removes and returns the most top element of stack
     *
     * @return the most top element of stack.
     * @throws Exception if stack is empty.
     */
    public T pop() throws Exception;

    /**
     * @return size of stack.
     */
    public int getSize();

    /**
     * removes all the elements from stack.
     */
    public void clear();

    /**
     * @return a String representation of stack
     */
    @Override
    public String toString();
}
