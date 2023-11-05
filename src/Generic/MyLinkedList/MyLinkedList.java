package Generic.MyLinkedList;

import java.lang.module.InvalidModuleDescriptorException;

public class MyLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    private void add(T val){
        if(firstNode == null){
            firstNode = new Node<>(null , null, val);
        }else if (lastNode == null){
            lastNode = new Node<>(firstNode, null, val);
            firstNode.setNextNode(lastNode);
        } else{
           Node<T> newLastNode = new Node<>(lastNode, null, val);
           lastNode.setNextNode(newLastNode);
           lastNode = newLastNode;
        }
        size++;
    }
    public T get(int index){
        Node<T> currentNode = firstNode;
        for(int i = 0; i < index; i++){
          currentNode = currentNode.getNextNode();
        }
        return currentNode.getValue();
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        Node<T> nodeToRemove = getNodeAtIndex(index);
        Node<T> prevNode = nodeToRemove.getPrevNode();
        Node<T> nextNode = nodeToRemove.getNextNode();
        if (prevNode != null) {
            prevNode.setNextNode(nextNode);
        } else {
            firstNode = nextNode;
            if (nextNode != null) {
                nextNode.setPrevNode(null);
            }
        }

        if (nextNode != null) {
            nextNode.setPrevNode(prevNode);
        } else {
            lastNode = prevNode;
            if (prevNode != null) {
                prevNode.setNextNode(null);
            }
        }

        size--;
    }
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private Node<T> getNodeAtIndex(int index) {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

}
