package HomeWork_2;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> implements List<T> {
    static class Node<T> {
        T element;
        Node next;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> LinkedList<T> of(T... elements) {
        LinkedList<T> linkedList = new LinkedList<>();
        for (T e : elements) {
            linkedList.add(e);
        }
        return linkedList;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = this.last = newNode;
        }else{
            this.last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index,size+1);
        Node<T> newNode = new Node<>(element);
        if(first == null){
            first=last=newNode;
        }else if(index == 0){
            newNode.next = first;
            first=newNode;
        }else if(index == size){
            last.next = newNode;
            last = newNode;
        }else{
            Node<T> current = getNodeByIndex(index+1);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index,size);
        Node<T> node = getNodeByIndex(index);
        node.element = element;
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        Objects.checkIndex(index,size);
        return getNodeByIndex(index).element;
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getFirst() {
        if(isEmpty()){
            throw new NoSuchElementException();

        }
        return get(0);
    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getLast() {
        if(isEmpty()){
            throw new NoSuchElementException();

        }
        return get(size-1);
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return deleted element
     */
    @Override
    public T remove(int index) {
        Objects.checkIndex(index,size);
        T removeElement;
        if(index == 0){
           removeElement = first.element;
           first = first.next;
           if(first == null){
               last = null;
           }
        }else {
            Node<T> prev = getNodeByIndex(index - 1);
            removeElement = (T) prev.next.element;
            prev.next = prev.next.next;
            if(index == size -1){
                last = prev;
            }
        }
        size--;
        return removeElement;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        Node<T> current = first;
        for (int i = 0; i < size ; i++) {
            if(current.element.equals(element)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return first == null ? true : false;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
       return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        first = last = null;
        size = 0 ;
    }
}