import org.w3c.dom.Node;

public class MyQueue {
    private Node head;
    private Node tail;
    private int size;

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.getValue();
    }

    public Object poll() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Object value = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }
}