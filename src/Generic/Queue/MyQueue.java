package Generic.Queue;

public class MyQueue {
        private Object[] data;
        private int size;
        private int front;
        private int rear;

        public MyQueue() {
            data = new Object[10];
            size = 0;
            front = -1;
            rear = -1;
        }


        public void add(Object value) {
            if (size == data.length) {
                increaseCapacity();
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % data.length;
            data[rear] = value;
            size++;
        }

        public void clear() {
            data = new Object[10];
            size = 0;
            front = -1;
            rear = -1;
        }

        public int size() {
            return size;
        }

        public Object peek() {
            if (front == -1) {
                throw new IllegalStateException("Черга порожня");
            }
            return data[front];
        }

        public Object poll() {
            if (front == -1) {
                throw new IllegalStateException("Черга порожня");
            }
            Object element = data[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % data.length;
            }
            size--;
            return element;
        }

        private void increaseCapacity() {
            int newCapacity = data.length * 2;
            Object[] newData = new Object[newCapacity];
            int j = 0;
            for (int i = front; i <= rear; i++) {
                newData[j] = data[i];
                j++;
            }
            data = newData;
            front = 0;
            rear = size - 1;
        }
    }
