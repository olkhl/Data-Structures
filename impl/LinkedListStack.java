//Chingizkhan Tangirbergenov & Olzhas Sutemgenov
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Stack;

/**
 *
 * @author Chingizkhan Tangirbergenov & Olzhas Sutemgenov
 * @param <T>
 */
public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;
    
    public LinkedListStack(){
        top  = null;
        size = 0;
    }
    @Override
    public void push(T value) {
      Node node = new Node(value);
      node.setLink(top);
      top=node;
      size++;
        
    }

    @Override
    public T pop() throws Exception {
        if (size == 0) 
        {
            throw new Exception("The Stack is empty");
        }
        Node<T> node = top;
        top=top.getLink();
        size--;
        return node.getValue();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top  = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        String res = "";
        Node  current = top;
        while (current.getLink() != null) 
        {
            
            current = current.getLink();
            res += current.getValue() + " ";
        }
        return top.getValue() + " "+ res;
    }
}
