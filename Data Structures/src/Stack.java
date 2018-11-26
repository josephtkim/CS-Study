public class Stack<T> {

    private Object[] items;
    private int size;
    private int topIndex;

    public Stack(int size) {
        this.size = size;
        this.items = new Object[size];
        this.topIndex = -1;
    }


    public void push(T item) {
        if (!isFull()) {
            this.items[++this.topIndex] = item;
        } else {
            System.out.println("Stack is full");
        }
    }


    public T pop() {
        if (!isEmpty()) {
            T item = (T)this.items[this.topIndex];
            this.topIndex--;
            return item;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    public T top() {
        if (!isEmpty()) {
            T item = (T)this.items[this.topIndex];
            return item;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    public boolean isFull() {
        return this.topIndex + 1 == this.size;
    }


    public boolean isEmpty() {
        return this.topIndex == -1;
    }




    public static void main(String[] args) {
        Stack stack = new Stack(5);

        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.isFull());
        System.out.println(stack.top());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}