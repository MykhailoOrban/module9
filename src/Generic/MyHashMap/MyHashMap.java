package Generic.MyHashMap;

import java.util.ArrayList;
import java.util.Arrays;

public class MyHashMap {
        private Node[] table;
        private int capacity;
        private int size;

        public MyHashMap(int capacity) {
            this.capacity = capacity;
            this.table = new Node[capacity];
            this.size = 0;
        }

        public MyHashMap() {
            this(16); // За замовчуванням, якщо не вказана початкова ємність
        }

        public void put(Object key, Object value) {
            int index = getIndex(key);
            Node newNode = new Node(key, value);

            if (table[index] == null) {
                table[index] = newNode;
            } else {
                Node current = table[index];
                while (current.getNext() != null) {
                    if (current.getKey().equals(key)) {
                        current.getValue() = value;
                        return;
                    }
                    current = current.getNext();
                }
                if (current.getKey().equals(key)) {
                    current.getValue() = value;
                } else {
                    current.getNext() = newNode;
                }
            }
            size++;
        }

        public Object get(Object key) {
            int index = getIndex(key);
            Node current = table[index];

            while (current != null) {
                if (current.getKey().equals(key)) {
                    return current.getValue();
                }
                current = current.getNext();
            }

            return null; // Ключ не знайдено
        }

        public void remove(Object key) {
            int index = getIndex(key);
            Node current = table[index];
            Node prev = null;

            while (current != null) {
                if (current.getKey().equals(key)) {
                    if (prev == null) {
                        table[index] = current.getNext();
                    } else {
                        prev.getNext() = current.getNext();
                    }
                    size--;
                    return;
                }
                prev = current;
                current = current.getNext();
            }
        }

        public void clear() {
            Arrays.fill(table, null);
            size = 0;
        }

        public int size() {
            return size;
        }

        private int getIndex(Object key) {
            if (key == null) {
                return 0;
            }
            return Math.abs(key.hashCode() % capacity);
        }
}
