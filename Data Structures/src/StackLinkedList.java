/*
Stack implemented with Linked list under the hood.
 */

import java.util.LinkedList;

public class StackLinkedList<T> {

    private LinkedList<T> items;

    public StackLinkedList() {
        this.items = new LinkedList<>();
    }

    public void push(T item) {
        items.addLast(item);
    }

    public T pop() {
        if (!items.isEmpty()) {
            T item = items.getLast();
            items.removeLast();
            return item;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    public T top() {
        if (!items.isEmpty()) {
            return items.getLast();
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());

        stack.push("A");
        stack.push("B");
        stack.push("C");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println(stack.isEmpty());
    }
}