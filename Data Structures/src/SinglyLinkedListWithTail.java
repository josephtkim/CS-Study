/*
Singly Linked List implemented with tail pointer.
 */
public class SinglyLinkedListWithTail {

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public SinglyLinkedListWithTail() {
        this.head = null;
        this.tail = null;
    }

    public void addFront(int value) {
        Node temp = new Node(value);

        if (head == null) {
            this.head = temp;
            this.tail = temp;
            return;
        } else {
            temp.next = this.head;
            this.head = temp;
        }
    }

    public int popFront() {
        if (!isEmpty()) { // 1 or more nodes
            int value = this.head.value;

            // Only 1 node, when head and tail are same node
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
            }

            return value;
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

        if (!isEmpty()) {
            this.tail.next = temp;
            this.tail = temp;
        } else { // Linked list is empty
            this.head = temp;
            this.tail = temp;
        }
    }

    public int popBack() {
        if (!isEmpty()) {
            // Only 1 node
            if (this.head == this.tail) {
                int value = this.tail.value;
                this.head = null;
                this.tail = null;
                return value;
            } else { // more than 1 node, just remove and replace the tail pointer
                int value = this.tail.value;

                Node current = this.head;
                while (current.next.next != null) {
                    current = current.next;
                }

                current.next = null;
                this.tail = current;
                return value;
            }
        } else {
            System.out.println("Linked list is empty");
            return -1;
        }
    }

    public int back() {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return -1;
        } else {
            return this.tail.value;
        }
    }

    public void insertAt(int value, int index) {
        if (index < 0) {
            System.out.println("Index cannot be negative");
            return;
        }

        if (index == 0) {
            addFront(value);
            return;
        }

        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        int counter = 1;
        Node current = this.head;
        Node temp = new Node(value);

        while (current.next != null) {
            if (counter == index) {
                // Adding to tail
                if (current.next == null) {
                    current.next = temp;
                    this.tail = temp;
                    return;
                } else { // Neither at tail or head
                    Node currentNext = current.next;
                    temp.next = currentNext;
                    current.next = temp;
                    return;
                }
            }

            current = current.next;
            counter++;
        }

        if (counter == index) {
            current.next = temp;
            this.tail = temp;
            return;
        }

        System.out.println("Invalid index");
    }

    public void insertAfter(int value, int key) {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        Node current = this.head;
        Node temp = new Node(value);

        while (current.next != null) {
            if (current.value == key) {
                Node currentNext = current.next;
                temp.next = currentNext;
                current.next = temp;
                return;
            }

            current = current.next;
        }

        if (current.value == key) {
            // Must be at the tail
            current.next = temp;
            this.tail = temp;
            return;
        }

        System.out.println("Could not insert");
    }

    public void insertBefore(int value, int key) {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        Node current = this.head;
        Node temp = new Node(value);

        // inserting before the head node
        if (current.value == key) {
            temp.next = current;
            this.head = temp;
            return;
        }

        while (current.next != null) {
            if (current.next.value == key) {
                Node currentNext = current.next;
                temp.next = currentNext;
                current.next = temp;
                return;
            }

            current = current.next;
        }

        System.out.println("Could not insert");
    }

    public void remove(int key) {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        // Head is the key
        if (this.head.value == key) {
            // Only 1 node in linked list to remove, which means it must be tail as well
            if (this.head == this.tail) {
                this.tail = null;
            }

            this.head = this.head.next;
            return;
        }

        Node current = this.head;
        while (current.next != null) {
            if (current.next.value == key) {
                // Check if tail
                if (current.next == this.tail) {
                    this.tail = current;
                }

                current.next = current.next.next;
                return;
            }

            current = current.next;
        }

        System.out.println("Could not remove node");
    }

    public int getSize() {
        int size = 0;

        Node current = this.head;
        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void traverse() {
        Node current = this.head;

        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.println("");
        int headValue = -1;
        int tailValue = -1;

        if (this.head != null) {
            headValue = this.head.value;
        }
        if (this.tail != null) {
            tailValue = this.tail.value;
        }

        System.out.print("Current head is: " + headValue + " Current tail is: " + tailValue);
        System.out.println("");
    }

    public static void main(String[] args) {
        SinglyLinkedListWithTail linkedList = new SinglyLinkedListWithTail();

        System.out.println(linkedList.isEmpty());
        // Front methods
        System.out.println("Front methods");
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);
        linkedList.traverse();
        System.out.println(linkedList.isEmpty());

        System.out.println(linkedList.popFront());
        System.out.println(linkedList.front());
        linkedList.traverse();
        System.out.println(linkedList.popFront());
        System.out.println(linkedList.popFront());
        System.out.println(linkedList.front());

        linkedList.traverse();

        // Back methods
        System.out.println("Back methods");
        linkedList.addBack(5);
        linkedList.traverse();
        linkedList.addBack(6);
        System.out.println(linkedList.back());
        System.out.println(linkedList.popBack());
        linkedList.addBack(7);

        linkedList.traverse();

        linkedList.popBack();
        linkedList.traverse();
        linkedList.popBack();
        linkedList.traverse();
        linkedList.popBack();
        linkedList.traverse();

        // Inserting at
        linkedList.insertAt(1, 0);
        linkedList.insertAt(2, 0);
        linkedList.traverse();
        linkedList.insertAt(3, 4);
        linkedList.insertAt(4, 2);
        linkedList.insertAt(5, 1);
        linkedList.traverse();

        // Inserting after
        linkedList.insertAfter(6, 1);
        linkedList.insertAfter(7, 2);
        linkedList.insertAfter(7, 4);
        linkedList.insertAfter(7, 10);
        linkedList.traverse();

        // Inserting before
        linkedList.insertBefore(8, 2);
        linkedList.insertBefore(9, 8);
        linkedList.insertBefore(10, 9);
        linkedList.insertBefore(5, 4);
        linkedList.traverse();

        System.out.println(linkedList.getSize());

        // Remove at index
        linkedList.remove(10);
        linkedList.remove(9);
        linkedList.remove(8);
        linkedList.remove(7);
        linkedList.remove(6);
        linkedList.traverse();

        linkedList.remove(5);
        linkedList.remove(5);
        linkedList.remove(4);
        linkedList.remove(2);
        linkedList.remove(1);
        linkedList.traverse();

        linkedList.remove(1);
        linkedList.remove(7);
        linkedList.remove(2);
        linkedList.remove(3);
        linkedList.traverse();
    }
}
