package Map;

import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V> {
    private Node<K, V> head;
    private Node<K, V> rear;
    private int numberOfElements = 0;


    private Node<K, V> put(K key, V value) {
        Node<K, V> nodeContains = containsKey(key);
        if (isEmpty()) {
            head = new Node<>(key, value, null);
            rear = head;
            return head;
        } else if (nodeContains != null) {
            containsKey(key).setValue(value);
            return nodeContains;
        } else {
            Node<K, V> newNode = new Node<>(key, value, null);
            newNode.setPrevious(rear);
            rear.setNext(newNode);
            rear = newNode;
            return rear;
        }
    }

    public Node<K, V> remove(K key) {
        Node<K, V> nodeContains = containsKey(key);
        if (nodeContains != null) {
            nodeContains.getPrevious().setNext(nodeContains.getNext());
            nodeContains.getNext().setPrevious(nodeContains.getPrevious());
        }
        return nodeContains;
    }

    public V get(K key) {
        Node<K, V> nodeContains = containsKey(key);
        if (nodeContains != null) {
            return nodeContains.getValue();
        }
        return null;
    }

    public Node<K, V> containsKey(K key) {
        if (!isEmpty()) {
            int code = key.hashCode();
            if (head.getId() == code) {
                return head;
            }
            Node<K, V> nodeNext = head.getNext();
            while (nodeNext != null) {
                if (nodeNext.getId() == code) {
                    return nodeNext;
                }
                nodeNext = nodeNext.getNext();
            }
        }
        return null;
    }

    public Node<K, V> containsValue(V value) {
        if (!isEmpty()) {
            if (head.getValue() == value)
                return head;
        } else {
            Node<K, V> nodeNext = head.getNext();
            while (nodeNext != null) {
                if (nodeNext.getValue() == value) {
                    return nodeNext;
                }
                nodeNext = nodeNext.getNext();
            }
        }
        return null;
    }


    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        if (!isEmpty()) {
            keySet.add(head.getKey());
            Node<K, V> nodeNext = head.getNext();
            while (nodeNext != null) {
                keySet.add(nodeNext.getKey());
                nodeNext = nodeNext.getNext();
            }
        }
        return keySet;
    }

    public Set<V> value() {
        Set<V> value = new HashSet<>();
        if (!isEmpty()) {
            value.add(head.getValue());
            Node<K, V> nodeNext = head.getNext();
            while (nodeNext != null) {
                value.add(nodeNext.getValue());
                nodeNext = nodeNext.getNext();
            }
        }
        return value;
    }
}
