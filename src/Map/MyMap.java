package Map;

import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V> {
    private NodeMap<K, V> head;
    private NodeMap<K, V> rear;
    private int numberOfElements = 0;


    public NodeMap<K, V> put(K key, V value) {
        NodeMap<K, V> nodeMapContains = containsKey(key);
        if (isEmpty()) {
            head = new NodeMap<>(key, value, null);
            rear = head;
            return head;
        } else if (nodeMapContains != null) {
            containsKey(key).setValue(value);
            return nodeMapContains;
        } else {
            NodeMap<K, V> newNodeMap = new NodeMap<>(key, value, null);
            newNodeMap.setPrevious(rear);
            rear.setNext(newNodeMap);
            rear = newNodeMap;
            return rear;
        }
    }

    public NodeMap<K, V> remove(K key) {
        NodeMap<K, V> nodeMapContains = containsKey(key);
        if (nodeMapContains != null) {
            nodeMapContains.getPrevious().setNext(nodeMapContains.getNext());
            nodeMapContains.getNext().setPrevious(nodeMapContains.getPrevious());
        }
        return nodeMapContains;
    }

    public V get(K key) {
        NodeMap<K, V> nodeMapContains = containsKey(key);
        if (nodeMapContains != null) {
            return nodeMapContains.getValue();
        }
        return null;
    }

    public NodeMap<K, V> containsKey(K key) {
        if (!isEmpty()) {
            int code = key.hashCode();
            if (head.getId() == code) {
                return head;
            }
            NodeMap<K, V> nodeMapNext = head.getNext();
            while (nodeMapNext != null) {
                if (nodeMapNext.getId() == code) {
                    return nodeMapNext;
                }
                nodeMapNext = nodeMapNext.getNext();
            }
        }
        return null;
    }

    public NodeMap<K, V> containsValue(V value) {
        if (!isEmpty()) {
            if (head.getValue() == value)
                return head;
        } else {
            NodeMap<K, V> nodeMapNext = head.getNext();
            while (nodeMapNext != null) {
                if (nodeMapNext.getValue() == value) {
                    return nodeMapNext;
                }
                nodeMapNext = nodeMapNext.getNext();
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
            NodeMap<K, V> nodeMapNext = head.getNext();
            while (nodeMapNext != null) {
                keySet.add(nodeMapNext.getKey());
                nodeMapNext = nodeMapNext.getNext();
            }
        }
        return keySet;
    }

    public Set<V> value() {
        Set<V> value = new HashSet<>();
        if (!isEmpty()) {
            value.add(head.getValue());
            NodeMap<K, V> nodeMapNext = head.getNext();
            while (nodeMapNext != null) {
                value.add(nodeMapNext.getValue());
                nodeMapNext = nodeMapNext.getNext();
            }
        }
        return value;
    }
}
