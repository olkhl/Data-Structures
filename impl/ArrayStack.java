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
public class ArrayStack<T> implements Stack<T> {
    
    private T[] values;
    private int size;

    
    public ArrayStack() {
        values = (T[])new Object[3];
        size = 0;
    }

    @Override
    public void push(T value) {
        if (size == values.length){
  
            T[] val2 = (T[])new Object[values.length*2];

            for (int i = 0; i < values.length; i++)
                val2[i] = values[i];

            values = (T[])new Object[values.length*2];
            
            values = val2;
            
            values[size] = value;
            size++;
            
        } else {
            values[size] = value;
            size++;                
        }
    }

    @Override
    public T pop() throws Exception {
        if (size == 0)
        {
            throw new Exception("The stack is empty");
        }
        else
        {
            T res = values[size-1];
            values[size-1] = null;
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
        values = (T[])new Object[3];
        size = 0;
    }
    
    public String toString(){
        String res = "Stack: ";
        for (int i = 0; i < size; i++){
            res += (values[i] + " "); 
        }
        return res;
    }

 
    
}
