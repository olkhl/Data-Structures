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
 * @param <T>
 * @author Chingizkhan Tangirbergenov & Olzhas Sutemgenov
 */
public class ArrayQueue<T> implements Queue<T>{

    private T[] values;
    private int size;
    private int front;
    private int back;
    
    public ArrayQueue(){
        values = (T[])new Object[5];
        size = 0;
        front = 0;
        back = -1;
    }
    
    @Override
    public void enqueue(T value) {
        if (size == values.length){
            T[] val = (T[])new Object[values.length*2];
            for (int i = 0; i < size; i++) {
                val[i] = values[(front + i) % values.length]; 
            }
            val[size] = value;
            back = size;
            size++;
            values = val;
            front = 0;
        }else {
            back = (back + 1) % values.length;
            values[back] = value;
            size++;
        }
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0)
        {
            throw new Exception("The queue is empty");
        }else{
            T res = values[front];
            values[front] = null;
            front = (front + 1) % values.length;
            size--;
            return res;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = (T[])new Object[5];
        size = 0;
        front = 0;
        back = -1;
    }
    
    @Override
    public String toString(){
        String res = "Queue: ";
        for (int i = 0; i < size; i ++)
            res = res + values[(front+i)%values.length] + " ";
        return res;
    }
    
}
