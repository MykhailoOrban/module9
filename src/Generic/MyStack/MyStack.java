package Generic.MyStack;

public class MyStack {
    private Object[] data;
    private int size;
    private int top;

    public MyStack() {
        data = new Object[10];
        size = 0;
        top = -1;
    }

    // Додає елемент в стек
    public void push(Object value) {
        if (size == data.length) {
            increaseCapacity();
        }
        top++;
        data[top] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index > top) {
            throw new IndexOutOfBoundsException("Недійсний індекс");
        }
        for (int i = index; i < top; i++) {
            data[i] = data[i + 1];
        }
        data[top] = null;
        top--;
        size--;
    }

    public void clear() {
        data = new Object[10];
        size = 0;
        top = -1;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (top == -1) {
            throw new IllegalStateException("Стек порожній");
        }
        return data[top];
    }

    public Object pop() {
        if (top == -1) {
            throw new IllegalStateException("Стек порожній");
        }
        Object element = data[top];
        data[top] = null;
        top--;
        size--;
        return element;
    }

    private void increaseCapacity() {
        int newCapacity = data.length * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}