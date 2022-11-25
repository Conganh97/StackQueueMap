package Map;

public class Node <K,V> {
    private int id;
    private K key;
    private V value;
    private Node <K,V> next;

    private Node <K,V> previous;

    public Node( K key, V value, Node<K, V> next) {
        this.id = code(key);
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Node<K, V> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<K, V> previos) {
        this.previous = previos;
    }

    public int code (K key){
        return key.hashCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
