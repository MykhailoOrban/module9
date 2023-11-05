package Generic.MyHashMap;

public class Node <T> {
   private T key;
   private T value;
    private Node<T> next;

    public Node (T key, T value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}