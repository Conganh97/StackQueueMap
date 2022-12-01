package MyStack;

public class Node<E> {
    private E value;


    private Node<E> previous;


    Node(Node<E> prev, E element) {
        this.value = element;
        this.previous = prev;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }






    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
}
