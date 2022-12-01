package Map;

public class Node<K,V> {
    private int hash;
    private K key;
    private V value;
    private Node<K,V> next;



    public Node(K key, V value, Node<K, V> next,int capacity) {
        this.hash = hashCode(key,capacity);
        this.key = key;
        this.value = value;
        this.next = next;
    }


    public int hashCode (K key,int capacity){
        return key.hashCode() & (capacity-1);
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }
}
