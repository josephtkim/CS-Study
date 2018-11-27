/*
Singly Linked List without tail pointer
 */
public class SinglyLinkedList {

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void addFront(int value) {
        Node temp = new Node(value);

        if (this.head == null) {
            this.head = temp;
        } else {
            temp.next = this.head;
            this.head = temp;
        }
    }

    public int popFront() {
        if (!isEmpty()) {
            int front = this.head.value;
            this.head = this.head.next;
            return front;
        } else {
            System.out.println("Linked list is empty");
            return -1;
        }
    }

    public int front() {
        if (!isEmpty()) {
            return this.head.value;
        } else {
            System.out.println("Linked list is empty");
            return -1;
        }
    }

    public void addBack(int value) {
        Node temp = new Node(value);

        if (isEmpty()) {
            this.head = temp;
            return;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
    }

    public int popBack() {
        if (!isEmpty()) {
            Node current = this.head;

            // Head node is at the back
            if (current.next == null) {
                int value = current.value;
                this.head = null;
                return value;
            }

            // Otherwise, find second to last node to remove last node
            while (current.next.next != null) {
                current = current.next;
            }

            int value = current.next.value;
            current.next = null;
            return value;
        } else {
            System.out.println("Linked list is empty");
            return -1;
        }
    }

    public int back() {
        if (!isEmpty()) {
            Node current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            return current.value;
        } else {
            System.out.println("Linked list is empty");
            return -1;
        }
    }

    public void insertAt(int value, int index) {

        // Negative index is invalid
        if (index < 0) {
            System.out.println("Invalid index!");
            return;
        }

        // 0 is adding to head
        if (index == 0) {
            addFront(value);
            return;
        }

        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = new Node(value);

        Node current = this.head;
        int counter = 1;

        while (counter != index && current.next != null) {
            current = current.next;
            counter += 1;
        }

        if (counter == index) {
            Node currentNext = current.next;
            current.next = temp;
            temp.next = currentNext;

            return;
        } else {
            System.out.println("Index is out of range");
            return;
        }
    }

    public void insertAfter(int value, int key) {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = new Node(value);
        Node current = this.head;

        while (current.next != null) {
            if (current.value == key) {
                Node next = current.next;
                current.next = temp;
                temp.next = next;
                return;
            }

            current = current.next;
        }

        if (current.value == key) {
            Node next = current.next;
            current.next = temp;
            temp.next = next;
            return;
        }

        System.out.println("Node not found");
        return;
    }

    public void insertBefore(int value, int key) {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        Node temp = new Node(value);
        Node current = this.head;

        // Target is at head
        if (current.value == key) {
            temp.next = current;
            this.head = temp;
            return;
        }

        // Target is elsewhere
        while (current.next != null) {
            // Found the key to insert befores
            if (current.next.value == key) {
                Node currentNext = current.next;
                temp.next = currentNext;
                current.next = temp;
                return;
            }

            current = current.next;
        }

        System.out.println("Key not found.");
    }

    public void remove(int key) {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        Node current = this.head;

        if (current.value == key) {
            this.head = current.next;
            return;
        }

        while (current.next != null) {
            if (current.next.value == key) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }

        System.out.println("Key not found");
        return;
    }

    public int getSize() {
        int size = 0;
        Node temp = this.head;

        while (temp != null) {
            size += 1;
            temp = temp.next;
        }

        return size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void traverse() { // Traverse linked list and print nodes
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        System.out.println("Empty list");
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.getSize());

        System.out.println("Adding values to list");
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.getSize());

        linkedList.traverse();

        System.out.println("Removing from the front");
        System.out.println(linkedList.popFront());

        linkedList.traverse();
        System.out.println(linkedList.popFront());
        System.out.println(linkedList.popFront());
        System.out.println(linkedList.popFront());

        linkedList.traverse();

        System.out.println("Adding and removing from back");

        linkedList.addBack(5);
        linkedList.addBack(6);
        linkedList.addBack(7);

        linkedList.traverse();

        System.out.println(linkedList.back());
        System.out.println(linkedList.popBack());
        System.out.println(linkedList.popBack());
        System.out.println(linkedList.popBack());

        linkedList.traverse();

        System.out.println("Adding at index");

        linkedList.insertAt(11, 0);
        linkedList.traverse();
        linkedList.insertAt(13, 1);
        linkedList.insertAt(23, 1);
        linkedList.insertAt(33, 1);
        linkedList.insertAt(52, 4);
        linkedList.traverse();

        System.out.println("Inserting after key");
        linkedList.insertAfter(60, 33);
        linkedList.traverse();

        linkedList.insertAfter(70, 3);
        linkedList.traverse();

        linkedList.insertAfter(60, 52);
        linkedList.traverse();

        System.out.println(linkedList.popBack());
        System.out.println(linkedList.popBack());
        System.out.println(linkedList.popBack());
        System.out.println(linkedList.popBack());
        System.out.println(linkedList.popBack());
        System.out.println(linkedList.popBack());
        linkedList.traverse();

        System.out.println("Inserting before key");
        linkedList.insertBefore(30, 11);
        linkedList.insertBefore(51, 11);
        linkedList.traverse();

        System.out.println("Removing by key");
        linkedList.remove(51);
        linkedList.traverse();
        linkedList.remove(30);
        linkedList.traverse();
        linkedList.remove(1);
        linkedList.traverse();

        linkedList.remove(11);
        linkedList.traverse();
    }
}