package coll;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(3);
        stack.push(5);
        stack.push(3);
        stack.push(6);
        System.out.println(stack.peek());
        System.out.println(stack.get(0));
        System.out.println(stack.search(3));
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        LinkedList<Integer> linkedList=new LinkedList();
        linkedList.add(3,4);
    }
}
