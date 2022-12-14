package MyStack;


import java.util.EmptyStackException;

public class MyStack<E> {
    public Node<E> top;
    public int numberOfElements = 0;


    boolean isEmpty() {
        return numberOfElements == 0;
    }

    public E push(E element) {
        if (element == null) {
            throw new NullPointerException();
        } else if (isEmpty()) {
            this.top = new Node<>(null, element);
        } else {
            Node<E> newElement = new Node<E>(top, element);
            this.top = newElement;
        }
        numberOfElements++;
        return element;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            E value = top.getValue();
            this.top = top.getPrevious();
            return value;
        }
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return this.top.getValue();
        }
    }
}
