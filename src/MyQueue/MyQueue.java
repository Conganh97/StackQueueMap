
package MyQueue;

import java.util.NoSuchElementException;

public class MyQueue<E> {
    public Node<E> first;
    public int numberOfElements = 0;


    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean add(E element) {
        boolean offerSuccess = offer(element);
        if (!offerSuccess) {
            throw new NullPointerException();
        }
        return true;
    }

    public boolean offer(E element) {
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            this.first = new Node<>(element, null);
        } else {
            Node<E> lastNode = findLastNode();
            Node<E> newNode = new Node(element, null);
            lastNode.setNext(newNode);
        }
        numberOfElements++;
        return true;
    }

    public Node<E> findLastNode() {
        Node<E> lastNode = this.first;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        return lastNode;
    }


    public E remove() {
        E value = poll();
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }


    public E peek() {
        if (isEmpty()) {
            return null;
        } else {
            return first.getValue();
        }
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        } else {
            E value = this.first.getValue();
            this.first = this.first.getNext();
            numberOfElements--;
            return value;
        }
    }

    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return first.getValue();
        }
    }

}
