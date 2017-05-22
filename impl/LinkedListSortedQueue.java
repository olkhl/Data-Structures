//Chingizkhan Tangirbergenov & Olzhas Sutemgenov
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.SortedQueue;

/**
 *
 * @author Chingizkhan Tangirbergenov & Olzhas Sutemgenov
 * @param <T>
 */
public class LinkedListSortedQueue<T  extends Comparable> implements SortedQueue<T> {

    private Node<T> front;
    private int size;

    public LinkedListSortedQueue() {
        front = null;
        size = 0;
    }

    @Override
    public void insert(T value) {

        Node<T> newNode = new Node(value);
        
        if (size == 0){
            front = newNode;
        }else{
            
            if (value.compareTo(front.getValue()) <= 0){
                newNode.setLink(front);
                front = newNode;
            }
            else{
                Node <T> curr = front;
                for (int i = 0; i < size - 1; i++){
                    if (value.compareTo(curr.getLink().getValue()) <= 0){
                        newNode.setLink(curr.getLink());
                        curr.setLink(newNode);
                        break;
                    }
                    curr = curr.getLink();
                }
                
                if (value.compareTo(curr.getValue()) > 0)
                {
                    curr.setLink(newNode);
                }
            }
            
            
        }

        
        
        size++;

    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("The Queue is empty");
        }
        Node<T> node = front;

        if (node.getLink() == null) {
            front = null;
        } else {
            front = node.getLink();
        }
        size--;
        return node.getValue();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        size = 0;
    }

    @Override
    public String toString() {
        String res = "";
        Node<T> current = front;
        while (current != null) {
                res += current.getValue() + ", ";
                current = current.getLink();
            
        }
        if (this.getSize() == 0) {
            return "Empty Queue";
        }

        return res;

    }

}
