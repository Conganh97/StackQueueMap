package Map;

public class NodeMap<K,V> {
    private int id;
    private K key;
    private V value;
    private NodeMap<K,V> next;

    private NodeMap<K,V> previous;

    public NodeMap(K key, V value, NodeMap<K, V> next) {
        this.id = code(key);
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public NodeMap<K, V> getPrevious() {
        return previous;
    }

    public void setPrevious(NodeMap<K, V> previos) {
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

    public NodeMap<K, V> getNext() {
        return next;
    }

    public void setNext(NodeMap<K, V> next) {
        this.next = next;
    }
}
