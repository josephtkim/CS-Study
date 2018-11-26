/*
Automatic resizing array.
*/

public class DynamicArray<T> {

    private Object[] items;
    private int capacity;
    private int index;

    public DynamicArray(int size) {
        if (size <= 0) {
            System.out.println("Not a valid capacity. Initializing with capacity 1.");
            this.capacity = 1;
        } else {
            this.capacity = size;
        }

        this.items = new Object[this.capacity];
        this.index = -1;
    }

    public void add(T item) {
        if (isFull()) {
            // Double capacity of array and copy over old items
            resize(this.capacity * 2);
            add(item);
        } else {
            this.items[++index] = item;
        }
    }

    public T itemAt(int index) {
        if (index < 0 || index >= this.capacity) {
            System.out.println("Out of bounds");
            return null;
        } else {
            return (T)this.items[index];
        }
    }

    public int getCapacity() {
        return this.index + 1;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean isFull() {
        return (this.index + 1) >= this.capacity;
    }

    private void resize(int newSize) {
        // Copy old array
        Object[] oldArray = this.items.clone();

        // Double capacity of array
        this.capacity = this.capacity * 2;
        this.items = new Object[this.capacity];

        // Copy every item to new array
        for (int i = 0; i < oldArray.length; i++) {
            this.items[i] = oldArray[i];
        }
    }

    public void printArray() {
        for (int i = 0; i < this.items.length; i++) {
            System.out.print(this.items[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray(3);

        array.printArray();
        array.add("A");
        array.add("B");
        array.add("C");

        array.printArray();
        System.out.println(array.isFull());
        System.out.println(array.itemAt(2));
        System.out.println(array.getCapacity());
        System.out.println(array.capacity());

        array.add("D");

        array.printArray();
        System.out.println(array.isFull());
        System.out.println(array.itemAt(3));
        System.out.println(array.getCapacity());
        System.out.println(array.capacity());
    }
}