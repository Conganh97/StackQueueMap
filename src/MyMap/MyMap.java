
package MyMap;

import java.util.ArrayList;
import java.util.List;


public class MyMap<K, V> {
    public final static int DEFAULT_CAPACITY = 8;
    public int numberOfElements;
    public int capacity;
    public Node<K, V>[] table;

    public MyMap(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    public MyMap() {
        this(DEFAULT_CAPACITY);
    }

    public Node<K, V> put(K key, V value) {
        if (containsKey(key)) {
            Node<K, V> nodeEdit = getNote(key);
            nodeEdit.setValue(value);
            return nodeEdit;
        }
        int index = hashCode(key);
        System.out.println(index);
        Node<K, V> node = this.table[index];
        if (node == null) {
            Node<K, V> newNode = new Node(index, key, value, null);
            this.table[index] = newNode;
            numberOfElements++;
            return newNode;
        }
        while (node.getNext() != null) {
            node = node.getNext();
        }
        Node<K, V> newNode = new Node(index, key, value, null);
        node.setNext(newNode);
        numberOfElements++;
        return newNode;
    }

    public Node<K, V> remove(K key) {
        if (containsKey(key)) {
            int index = hashCode(key);
            Node<K, V> nodeRemove = this.table[index];
            if (this.table[index].getNext() == null) {
                this.table[index] = null;
                return nodeRemove;
            }
            while (nodeRemove.getNext().getKey() != key) {
                nodeRemove = nodeRemove.getNext();
            }
            nodeRemove.setNext(nodeRemove.getNext().getNext());
            numberOfElements--;
        }
        return null;
    }

    public V get(K key) {
        if (containsKey(key)) {
            return getNote(key).getValue();
        }
        return null;
    }

    public boolean containsKey(K key) {
        Node<K, V> node = getNote(key);
        return node != null;
    }


    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public List<K> keyList() {
        List<K> keyList = new ArrayList<>();
        if (!isEmpty()) {
            for (Node<K, V> nodeHead : this.table) {
                Node<K, V> nodeNext = nodeHead;
                while (nodeNext != null) {
                    keyList.add(nodeNext.getKey());
                    nodeNext = nodeNext.getNext();
                }
            }
        }
        return keyList;
    }

    public List<V> valueList() {
        List<V> valueList = new ArrayList<>();
        if (!isEmpty()) {
            for (Node<K, V> nodeHead : this.table) {
                Node<K, V> nodeNext = nodeHead;
                while (nodeNext != null) {
                    valueList.add(nodeNext.getValue());
                    nodeNext = nodeNext.getNext();
                }
            }
        }
        return valueList;
    }

    public int hashCode(K key) {
        if (key == null) return 0;
        return key.hashCode() & (capacity - 1);
    }

    public Node<K, V> getNote(K key) {
        int index = hashCode(key);
        Node<K, V> node = this.table[index];
        while (node != null) {
            if (node.getKey() == key) return node;
            node = node.getNext();
        }
        return null;
    }

    public List<Node<K, V>> nodeList() {
        List<Node<K, V>> nodeList = new ArrayList<>();
        if (!isEmpty()) {
            for (Node<K, V> nodeHead : this.table) {
                Node<K, V> nodeNext = nodeHead;
                while (nodeNext != null) {
                    nodeList.add(nodeNext);
                    nodeNext = nodeNext.getNext();
                }
            }
        }
        return nodeList;
    }

}
