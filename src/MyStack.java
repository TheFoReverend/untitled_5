import org.w3c.dom.Node;

public class MyStack {
    private Node top;
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            top = top.getNext();
        } else {
            Node prevNode = getNode(index - 1);
            Node nodeToRemove = prevNode.getNext();
            prevNode.setNext(nodeToRemove.getNext());
        }

        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.getValue();
    }

    public Object pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        Object value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    private Node getNode(int index) {
        Node currentNode = top;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }
}