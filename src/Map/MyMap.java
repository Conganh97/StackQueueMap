package Map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyMap<K, V> {
    public int numberOfElements = 0;
    public int capacity;
    public Node<K, V>[] table;

    public MyMap(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    public MyMap() {
        this(16);

    }

    public Node<K, V> put(K key, V value) {
        Node<K, V> nodeContains = containsKey(key);
        if (isEmpty()) {
            return null;
        } else if (nodeContains != null) {
            containsKey(key).setValue(value);
            return nodeContains;
        } else {
            Node<K, V> newNode = new Node<>(key, value, null, capacity);

            return newNode;
        }
    }

    public Node<K, V> remove(K key) {
        Node<K, V> nodeContains = containsKey(key);
        if (nodeContains != null) {

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
        int index = key.hashCode();

        if (this.table[index] != null) {

        }

        return null;
    }

    public Node<K, V> containsValue(V value) {
        if (!isEmpty()) {

        } else {


        }
        return null;
    }


    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public List<K> keySet() {
        List<K> keyList = new ArrayList<>();
        if (!isEmpty()) {
            for (Node nodeHead : this.table) {
                Node nodeNext = nodeHead;
                while (nodeNext != null) {
                    keyList.add((K) nodeNext.getKey());
                    nodeNext.getNext();
                }
            }
        }
        return keyList;
    }

    public List<V> value() {
        List<V> valueList = new ArrayList<>();
        if (!isEmpty()) {
            for (Node nodeHead : this.table) {
               Node nodeNext = nodeHead;
                while (nodeNext != null) {
                    valueList.add((V) nodeNext.getValue());
                    nodeNext.getNext();
                }
            }
        }
        return valueList;
    }
}
