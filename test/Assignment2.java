//Chingizkhan Tangirbergenov & Olzhas Sutemgenov
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.test;

import csci152.adt.Stack;
import csci152.adt.Queue;
import csci152.impl.LinkedListStack;
import csci152.impl.LinkedListQueue;


/**
 *
 * @author Chingizkhan Tangirbergenov & Olzhas Sutemgenov
 */
public class Assignment2 {

    public static boolean isIncreasing(Stack<Integer> st) {
        boolean b;
        b = false;
        Stack<Integer> temp = new LinkedListStack();
        int length = st.getSize();
        int prev;
        int next;

        try {
            prev = st.pop();
            temp.push(prev);

            for (int i = 0; i < length - 1; i++) {
                next = st.pop();
                if (next < prev) {
                    b = true;
                }
                temp.push(next);
                prev = next;
            }

            for (int i = 0; i < length; i++) 
                st.push(temp.pop());
        } catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }

        return b;
    }

    public static void absSort(Stack<Integer> st) throws Exception {

        Stack <Integer> temp1 = new LinkedListStack();
        Stack <Integer> temp2 = new LinkedListStack();
        int length = st.getSize();
        
        if (!isIncreasing(st)) 
            throw new Exception("Error: the stack is not in the increasing order");
        
        try{
            for (int i = 0; i < length; i++){
                temp2.push(st.pop());
            }
        
            for (int i = 0; i < length; i++){
                int val = temp2.pop();
                if (val < 0){
                    temp1.push(val);
                } else {
                    temp2.push(val);
                    break;
                }
            }

            boolean u = true;
            if (temp2.getSize() != 0 && temp1.getSize() != 0)
                u = false;
            while(!u){
                int val1 = temp1.pop();
                int val2 = temp2.pop();
                if (val2 < -1*val1){
                    st.push(val2);
                    temp1.push(val1);
                } else if (val2 >= -1*val1){
                    st.push(val1); 
                    temp2.push(val2);
                }
                if (temp2.getSize() == 0 || temp1.getSize() == 0)
                    u = true;                
            }
            if (temp2.getSize() == 0 && temp1.getSize() != 0){
                length = temp1.getSize();
                for (int i = 0; i < length; i++)
                    {
                        st.push(temp1.pop());
                    }
            }
            if (temp2.getSize() != 0 && temp1.getSize() == 0){
                length = temp2.getSize();
                for (int i = 0; i < length; i++)
                    {
                        st.push(temp2.pop());
                    }
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }    
    }

    public static boolean valid(char ch) {
        return (ch == '(') || (ch == ')') || (ch == '{') || (ch == '}') || (ch == '[') || (ch == ']');
    }

    public static boolean check(char ch1, char ch2) {
        if (((ch1 == '(') && (ch2 == ')')) || ((ch1 == '[') && (ch2 == ']')) || ((ch1 == '{') && (ch2 == '}'))) {
            return true;
        }
        return false;
    }
    
    public static boolean isBalanced(Queue<Character> q) throws Exception {
        boolean b;
        b = false;
        boolean proper;
        proper = true;
        Stack<Character> temp = new LinkedListStack();
        int len = q.getSize();

        for (int i = 0; i < len; i++) 
            try {
                char ch1 = q.dequeue();
                q.enqueue(ch1);
                if (!valid(ch1)) 
                    proper = false;
                if (temp.getSize() == 0) {
                    temp.push(ch1);
                } else {
                    char ch2 = temp.pop();
                    if (!check(ch2, ch1)) {
                        temp.push(ch2);
                        temp.push(ch1);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        if (!proper) {
            throw new Exception("Characters do not balanced properly");
        }

        if (temp.getSize() == 0) {
            b = true;
        }

        return b;
    }
    
    public static boolean isPalindrome(Queue<Character> q){
        boolean res;
        res = false;
        
        Queue <Character> tempQ = new LinkedListQueue();
        Stack <Character> tempS = new LinkedListStack();
        int length = q.getSize();

        try {
            for (int i = 0; i < length; i++){
                char ch = q.dequeue();
                tempS.push(ch);
                tempQ.enqueue(ch);
                q.enqueue(ch);
            }    

            for (int i = 0; i < length; i++){
                if (tempS.pop() == tempQ.dequeue())
                    res = true;
            }

        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return res;
    }
    
    public static void sort(Queue <Double> q){
        Stack <Double> temp1 = new LinkedListStack();
        Stack <Double> temp2 = new LinkedListStack();
        
        int length = q.getSize();
        try {
            for (int i = 0;i < length; i++)
               {
                double val1 = q.dequeue();
                if (temp1.getSize() == 0)
                {
                    temp1.push(val1);
                } else 
                   {
                    for (int j = 0; j != -1; j++)
                    {
                        if (temp1.getSize() == 0)
                        {
                            temp1.push(val1);
                            if (temp2.getSize() != 0)
                            {
                                int s = temp2.getSize();
                                for (int k = 0; k < s; k++)
                                {
                                    temp1.push(temp2.pop());
                                } 
                            }
                            break;
                        } else {
                            double val2 = temp1.pop();
                            if (val1 <= val2)
                            {
                                temp1.push(val2);
                                temp1.push(val1);
                                if (temp2.getSize() != 0)
                                {
                                    int s = temp2.getSize();
                                    for (int k = 0; k < s; k++)
                                    {
                                        temp1.push(temp2.pop());
                                    } 
                                }
                                break;
                            } else {
                                temp2.push(val2);
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < length; i++){
                q.enqueue(temp1.pop());
            }
            
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }   

    public static void main(String[] args) {

        Stack<Integer> st = new LinkedListStack();
        for (int i = 1; i < 7; i++) {
            st.push(i);
        }
        st.push(7);
        for (int i = 8; i < 12; i++) {
            st.push(i);
        }
        System.out.println(st);
        System.out.println("isIncrease method: " +isIncreasing(st) + " \n\n");

        
        Stack <Integer> s = new LinkedListStack();
        //-10, -4, -2, 3, 7, 8
        s.push(-10);
        s.push(-4);
        s.push(-2);
        s.push(3);
        s.push(7);
        s.push(8);
        
        try {
            absSort(s);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println(" absSorted method: " + s + "\n\n");
        System.out.println("isBalanced method: ");
        Queue<Character> q = new LinkedListQueue();
        q.enqueue('{');
        for (int i = 0; i < 4; i++) {
            q.enqueue('(');
            q.enqueue('[');
            q.enqueue('{');
            q.enqueue('}');
            q.enqueue(']');
            q.enqueue(')');
        }
        q.enqueue('}');
        
        try {
            System.out.println(isBalanced(q) + " " + q);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        Queue<Character> q1 = new LinkedListQueue();
        
        for (char i = 'a'; i <= 'e'; i++){
            q1.enqueue(i);
        }
        
        for (char i = 'f'; i >= 'd'; i--){
            q1.enqueue(i);
        }

        System.out.println("\n is Palinndrome method: " +isPalindrome(q1) + " " + q1);
        
        Queue<Double> q2 = new LinkedListQueue();
        for (double i = 9; i >= 0; i --)
            q2.enqueue(i);
        q2.enqueue(5.2);
        q2.enqueue(6.5);
        q2.enqueue(4.3);
        q2.enqueue(5.8);
        q2.enqueue(4.9);
        sort(q2); 
        System.out.println(q2);        
        
    }

}


