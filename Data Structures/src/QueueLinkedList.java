import java.util.Iterator;
import java.util.LinkedList;

/*
Queue implemented with a linked list.
Enqueue at the tail, dequeue at the head.
Keep a tail pointer.
 */
public class QueueLinkedList<T> {

    LinkedList<T> items;

    public QueueLinkedList() {
        items = new LinkedList<>();
    }

    public void enqueue(T value) {
        items.addLast(value);
    }

    public T dequeue() {
        if (!isEmpty()) {
            return items.poll();
        } else {
            System.out.println("Queue is empty");
            return null;
        }
    }

    public T front() {
        if (!isEmpty()) {
            return items.getFirst();
        } else {
            System.out.println("Queue is empty");
            return null;
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void printItems() {
        Iterator i = items.iterator();

        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        System.out.println(queue.isEmpty());
        System.out.println(queue.front());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.printItems();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.printItems();
    }
}
