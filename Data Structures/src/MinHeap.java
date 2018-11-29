/*
Min Binary Heap implementation using an array.
Sentinel at index 0.
*/
public class MinHeap {

    private int[] items;
    private int capacity;
    private int currentSize;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity + 1]; // Index 0 is sentinel so not used
        this.currentSize = 0;

        for (int i = 1; i < capacity + 1; i++) {
            this.items[i] = -1;
        }
    }

    public void minHeapify(int index) {
        // Check parent, left, and right values.
        // Get the smallest of the three values.
        // swap parent with smaller of children
        // Recursively call min heapify on the smallest index
        int smallest = index;
        int left = leftChildIdx(index);
        int right = rightChildIdx(index);

        // Check that left is valid index
        if (left <= this.currentSize && this.items[left] < this.items[index]) {
            smallest = left;
        }
        if (right <= this.currentSize && this.items[right] < this.items[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            int temp = this.items[smallest];
            this.items[smallest] = this.items[index];
            this.items[index] = temp;

            minHeapify(smallest);
        }
    }

    public void buildHeap(int[] array) {
        int newSize = array.length;

        this.items = new int[newSize + 1];
        for (int i = 0; i < newSize; i++) {
            this.items[i+1] = array[i];
        }

        this.capacity = newSize;
        this.currentSize = newSize;

        int start = (int) Math.floor(this.currentSize / 2);

        for (int i = start; i >= 1; i--) {
            minHeapify(i);
        }
    }

    public void heapSort(int[] array) {
        // Takes in an array of items and sorts it
        buildHeap(array);

        int oldSize = this.currentSize;

        for (int i = this.currentSize; i > 1; i--) {
            int temp = this.items[i];
            this.items[i] = this.items[1];
            this.items[1] = temp;

            this.currentSize--;
            minHeapify(1);
        }

        this.currentSize = oldSize;
    }

    public void bubbleUp(int index) {
        if (index <= 0 || index > this.currentSize) {
            System.out.println("Invalid index");
            return;
        } else {
            int currentIdx = index;
            int current = this.items[currentIdx];

            int parentIdx = getParentIdx(currentIdx);
            int parent = this.items[parentIdx];

            while (current < parent && parentIdx > 0) {
                // Swap with parent index and move up
                int temp = this.items[currentIdx];
                this.items[currentIdx] = parent;
                this.items[parentIdx] = temp;

                currentIdx = parentIdx;
                current = this.items[currentIdx];

                parentIdx = getParentIdx(currentIdx);
                parent = this.items[parentIdx];
            }
        }
    }
    public void bubbleDown(int index) {
        // Get the lesser child and swap to maintain minheap property
        if (index < 1 || index > this.currentSize) {
            System.out.println("Index is out of range.");
            return;
        }

        while (leftChildIdx(index) <= this.currentSize) {
            int lesserIdx = leftChildIdx(index);

            int leftValue = this.items[leftChildIdx(index)];
            int rightValue = this.items[rightChildIdx(index)];

            if (leftValue > rightValue) {
                lesserIdx = rightChildIdx(index);
            }


            if (this.items[index] < this.items[lesserIdx]) {
                // Swap with lesser child
                int temp = this.items[index];
                this.items[index] = this.items[lesserIdx];
                this.items[lesserIdx] = temp;
            } else {
                break;
            }

            index = lesserIdx;
        }
    }

    public int getMin() {
        if (!isEmpty()) {
            return this.items[1];
        } else {
            return -1;
        }
    }

    public int extractMin() {
        return removeAt(1);
    }

    public int getSize() {
        return this.currentSize;
    }
    public boolean isEmpty() {
        return this.currentSize == 0;
    }
    public boolean isFull() {
        return this.currentSize == this.capacity;
    }

    public int removeAt(int index) {
        if (!isEmpty()) {
            if (index < 1 || index > this.currentSize) {
                System.out.println("Invalid index");
                return -1;
            } else {
                // Swap element with last element
                int removed = this.items[index];
                this.items[index] = this.items[this.currentSize];
                minHeapify(index);
                this.items[this.currentSize] = 0;
                this.currentSize--;

                return removed;
            }
        } else {
            System.out.println("Heap is empty");
            return -1;
        }
    }

    public void insert(int value) {
        if (!isFull()) {
            this.items[this.currentSize + 1] = value;
            this.currentSize++;
            bubbleUp(this.currentSize); // Maintain heap property
        } else {
            System.out.println("Heap is full");
            return;
        }
    }

    public void decreaseKey(int index, int newValue) {
        if (newValue >= this.items[index]) {
            System.out.println("New key must be less");
            return;
        }

        this.items[index] = newValue;
        bubbleUp(index);
    }

    // Helper methods
    public int getParentIdx(int i) {
        return (int) Math.floor(i / 2);
    }
    public int leftChildIdx(int i) {
        return i * 2;
    }
    public int rightChildIdx(int i) {
        return (i * 2) + 1;
    }

    public void printHeap() {
        int index = 1;

        while (index <= this.currentSize) {
            System.out.print(this.items[index] + " ");
            index++;
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(5);
        heap.buildHeap(new int[]{5, 3, 2, 1, 8});
        heap.decreaseKey(4, 4);

        heap.heapSort(new int[]{5, 3, 2, 1, 8});
        heap.printHeap();


        heap.buildHeap(new int[]{19, 1, 18, 2, 23, 37, 34, 26, 5});
        System.out.println(heap.extractMin());
        heap.insert(100);
        System.out.println(heap.extractMin());
        heap.insert(3);

        heap.printHeap();

        System.out.println(heap.extractMin());
        heap.printHeap();
        System.out.println(heap.extractMin());
        heap.printHeap();
        System.out.println(heap.extractMin());
        heap.printHeap();



    }
}
