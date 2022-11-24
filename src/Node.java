import java.util.LinkedList;

public class Node<E> {
    private E value;
    private Node<E> next;

    private Node<E> previous;


    Node(Node<E> prev, E element, Node<E> next) {
        this.value = element;
        this.next = next;
        this.previous = prev;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }


    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
}
