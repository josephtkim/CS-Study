/*
Queue implemented with circular array under the hood.
*/

public class QueueCircularArray<T> {

    private int front;
    private int back;
    private Object[] items;
    private int capacity;
    private int currentSize;

    public QueueCircularArray(int capacity) {
        this.front = -1;
        this.back = -1;

        if (capacity < 1) {
            System.out.println("Invalid size. Initializing with size 5.");
            this.capacity = 5;
        } else {
            this.capacity = capacity;
        }

        this.items = new Object[capacity];
        this.currentSize = 0;
    }

    public void enqueue(T item) {
        if (!isFull()) {
            this.back = (this.back + 1) % this.capacity;
            this.items[this.back] = item;
            this.currentSize++;
            return;
        } else {
            System.out.println("Queue is full!");
            return;
        }
    }

    public T dequeue() {
        if (!isEmpty()) {
            this.front = (this.front + 1) % this.capacity;
            T item = (T)this.items[this.front];
            this.currentSize--;
            return item;
        } else {
            System.out.println("Queue is empty!");
            return null;
        }
    }

    public T front() {
        if (!isEmpty()) {
            int index = (this.front + 1) % this.capacity;
            T item = (T)this.items[index];
            return item;
        } else {
            System.out.println("Queue is empty");
            return null;
        }
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public boolean isFull() {
        return this.currentSize == this.capacity;
    }

    public void printItems() {
        int front = this.front;

        while (front != back) {
            System.out.print(this.items[front+1] + " ");
            front = (front + 1) % this.capacity;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        QueueCircularArray queue = new QueueCircularArray(6);

        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        queue.printItems();
        System.out.println(queue.dequeue());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        queue.enqueue("F");
        queue.enqueue("G");
        System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());
        queue.printItems();

        System.out.println(queue.front());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.printItems();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        queue.printItems();
    }
}
