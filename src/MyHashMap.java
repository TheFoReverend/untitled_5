import org.w3c.dom.Node;

public class MyHashMap {
    private static final int INITIAL_CAPACITY = 16;
    private Node[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = getIndex(key);

        Node newNode = new Node(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node currentNode = buckets[index];
            while (currentNode.getNext() != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    return;
                }
                currentNode = currentNode.getNext();
            }
            if (currentNode.getKey().equals(key)) {
                currentNode.setValue(value);
            } else {
                currentNode.setNext(newNode);
            }
        }

        size++;
    }

    public void remove(Object key) {
        int index = getIndex(key);

        if (buckets[index] == null) {
            return;
        }

        Node prevNode = null;
        Node currentNode = buckets[index];

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                if (prevNode == null) {
                    buckets[index] = currentNode.getNext();
                } else {
                    prevNode.setNext(currentNode.getNext());
                }
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    public void clear() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = getIndex(key);

        Node currentNode = buckets[index];
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }

        return null;
    }

    private int getIndex(Object key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }
}