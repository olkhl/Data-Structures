//Chingizkhan Tangirbergenov & Olzhas Sutemgenov
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;

/**
 *
 * @author Chingizkhan Tangirbergenov & Olzhas Sutemgenov
 * @param <T>
 */
public class LinkedListQueue<T> implements Queue<T> {

    private Node<T> front;
    private Node<T> back;
    private int size;

    public LinkedListQueue() {
        front = null;
        size = 0;
        back = null;
    }

    @Override
    public void enqueue(T value) {

        Node<T> node = new Node(value);
        if (size == 0) {
            front = node;
            back = node;
        } else {
            back.setLink(node);
            back = node;
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
            back = null;
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
        back = null;
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
