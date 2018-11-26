/*
Automatic resizing array.
*/

public class DynamicArray<T> {

    private Object[] items;
    private int size;
    private int index;

    public DynamicArray(int size) {
        if (size <= 0) {
            System.out.println("Not a valid size. Initializing with size 1.");
            this.size = 1;
        } else {
            this.size = size;
        }

        this.items = new Object[this.size];
        this.index = -1;
    }

    public void add(T item) {
        if (isFull()) {
            // Double size of array and copy over old items
            resize(this.size * 2);
            add(item);
        } else {
            this.items[++index] = item;
        }
    }

    public T itemAt(int index) {
        if (index < 0 || index >= this.size) {
            System.out.println("Out of bounds");
            return null;
        } else {
            return (T)this.items[index];
        }
    }

    public int getSize() {
        return this.index + 1;
    }

    public int capacity() {
        return this.size;
    }

    public boolean isFull() {
        return (this.index + 1) >= this.size;
    }

    private void resize(int newSize) {
        // Copy old array
        Object[] oldArray = this.items.clone();

        // Double size of array
        this.size = this.size * 2;
        this.items = new Object[this.size];

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
        System.out.println(array.getSize());
        System.out.println(array.capacity());

        array.add("D");

        array.printArray();
        System.out.println(array.isFull());
        System.out.println(array.itemAt(3));
        System.out.println(array.getSize());
        System.out.println(array.capacity());
    }
}