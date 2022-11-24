import java.util.NoSuchElementException;

public class MyQueue<E> {
    private Node<E> first;
    private Node<E> rear;
    private int numberOfElements = 0;


    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException();
        } else if (isEmpty()) {
            this.first = new Node<>(null, element, null);
            this.rear = first;
        } else {
            Node<E> temp = new Node<>(rear, element, null);
            this.rear.setNext(temp);
            this.rear = temp;
        }
        numberOfElements++;
        return true;
    }

    public boolean offer (E element) {
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            this.first = new Node<>(null, element, null);
            this.rear = first;
        } else {
            Node<E> temp = new Node<>(rear, element, null);
            this.rear.setNext(temp);
            this.rear = temp;
        }
        numberOfElements++;
        return true;
    }


    public E remove() {
        if (isEmpty()) {
           throw new NoSuchElementException();
        } else {
            Node <E> temp = this.first;
            this.first = this.first.getPrevious();
            this.first.setPrevious(null);
            numberOfElements--;
            return temp.getValue();
        }
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
            Node <E> temp = this.first;
            this.first = this.first.getPrevious();
            this.first.setPrevious(null);
            numberOfElements--;
            return temp.getValue();
        }
    }
    public E element (){
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return first.getValue();
        }
    }

}
