/*
Priority queue implemented with a min heap under the hood.
 */

import java.util.ArrayList;

public class PriorityQueue {
    class Entry implements Comparable<Entry>{
        // Determines priority of the entry. Lower keys should be at the top.
        // Basically, like normal heap, keys are the values of each node.
        int key;
        // Data is just "along for the ride"
        String data;

        public Entry(int key, String data) {
            this.key = key;
            this.data = data;
        }

        public int compareTo(Entry e) {
            return this.key - e.key;
        }
    }

    private ArrayList<Entry> items;
    private int currentSize;

    public PriorityQueue() {
        items = new ArrayList<>();
        currentSize = 0;

        // Add sentinel at index 0
        Entry sentinel = new Entry(-1,"Sentinel");
        items.add(sentinel);
    }

    public void insert(int key, String data) {
        currentSize++;
        Entry entry = new Entry(key, data);
        items.add(entry); // Inserts at end
        bubbleUp(currentSize); // Bubble up to maintain heap property
    }

    public void bubbleUp(int index) {
        if (isEmpty()) {
            return;
        }

        // "Bubble up from the last node in the heap"
        int parentIndex = parentIdx(index);

        while (items.get(index).compareTo(items.get(parentIndex)) < 0 && parentIndex > 0) {
            Entry temp = items.get(index);
            items.set(index, items.get(parentIndex));
            items.set(parentIndex, temp);

            index = parentIndex;
            parentIndex = parentIdx(index);
        }
    }

    public void bubbleDown() {
        if (isEmpty()) {
            return;
        }

        int currentIndex = 1;

        while (leftChildIdx(currentIndex) <= this.currentSize) {
            int leftChildIndex = leftChildIdx(currentIndex);
            int rightChildIndex = rightChildIdx(currentIndex);

            if (rightChildIndex > this.currentSize) {
                rightChildIndex = currentIndex;
            }
            int smallerChildIndex = currentIndex;

            // Get the smaller index
            if (items.get(leftChildIndex).compareTo(items.get(rightChildIndex)) < 0) {
                smallerChildIndex = leftChildIndex;
            } else {
                smallerChildIndex = rightChildIndex;
            }

            // Check if the smaller index is less than the parent
            if (items.get(smallerChildIndex).compareTo(items.get(currentIndex)) < 0) {
                Entry temp = items.get(smallerChildIndex);
                items.set(smallerChildIndex, items.get(currentIndex));
                items.set(currentIndex, temp);
            } else {
                return;
            }

            currentIndex = smallerChildIndex;
        }
    }

    public Entry extractMin() {
        if (isEmpty()) {
            System.out.println("Priority queue is empty!");
            return null;
        }

        // Swap the top value with the last value in heap
        Entry temp = items.get(1);
        items.set(1, items.get(currentSize));
        items.set(currentSize, temp);
        // decrement the index
        currentSize--;
        // bubbledown to maintain heap property
        bubbleDown();

        return temp;
    }

    public void decreaseKey(int oldKey, int newKey) {
        if (oldKey >= newKey) {
            System.out.println("New key must be smaller");
            return;
        }

        for (int i = 1; i < items.size(); i++) {
            if (items.get(i).key == oldKey) {
                // Update the key
                String data = items.get(i).data;
                items.set(i, new Entry(newKey, data));

                // Bubble up the node to maintain heap property
                bubbleUp(i);
                return;
            }
        }
    }

    public int parentIdx(int index) {
        return (int) (index / 2);
    }
    public int leftChildIdx(int index) {
        return index * 2;
    }
    public int rightChildIdx(int index) {
        return (index * 2) + 1;
    }

    public void printQueue() {
        for (int i = 1; i <= currentSize; i++) {
            System.out.print(items.get(i).key + ": " + items.get(i).data + " | ");
        }

        System.out.println("");
    }
    public Entry getMin() {
        if (!isEmpty()) {
            return items.get(1);
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    // Tests:
    // Create a heap with entries that have an index and data
    // Ensure that indices remain as valid heap structure.
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert(10, "A");
        pq.printQueue();
        pq.insert(5, "B");
        pq.insert(8, "C");
        pq.printQueue();
        pq.insert(13, "D");
        pq.printQueue();

        System.out.println("Extracting min");
        Entry e = pq.extractMin();
        System.out.println(e.key + ": " + e.data);
        pq.printQueue();

        System.out.println("Extracting min");
        e = pq.extractMin();
        System.out.println(e.key + ": " + e.data);
        pq.printQueue();

        System.out.println("Extracting min");
        e = pq.extractMin();
        System.out.println(e.key + ": " + e.data);
        pq.printQueue();

        System.out.println("Extracting min");
        e = pq.extractMin();
        System.out.println(e.key + ": " + e.data);
        pq.printQueue();

        System.out.println(pq.isEmpty());
    }
}
