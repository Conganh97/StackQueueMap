package StackQuere;

import java.util.EmptyStackException;

public class MyStack<E> {
    private Node<E> first;
    private Node<E> rear;
    private int numberOfElements = 0;


    boolean isEmpty (){
        return numberOfElements == 0;
    }

    public E push (E element){
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
        return element;
    }

    public E pop (){
        if (isEmpty()){
            throw  new EmptyStackException();
        } else {
            Node<E> temp = rear;
            this.rear = rear.getPrevious();
            this.rear.setNext(null);
            return temp.getValue();
        }
    }

    public E peek (){
        if (isEmpty()){
            throw  new EmptyStackException();
        } else {
            return this.rear.getValue();
        }
    }
}
