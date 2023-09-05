package com.codecool.linkedlist;

public class SinglyLinkedList <T> {

    private class Link <T> {

        private T value;
        private Link next;

        Link(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;

    public SinglyLinkedList() {
    }


    /**
     * Add a new element to the list.
     * The new element is appended to the current last item.
     *
     * @param value value to be appended
     */
    public void add(int value) {
        Link newData = new Link(value);
        if(head == null){
            head = newData;
        }
        else{
            Link allBeforeNodes = head;
            while(allBeforeNodes.getNext() != null){
                allBeforeNodes = allBeforeNodes.getNext();
            }
            allBeforeNodes.setNext(newData);
        }
    }

    /**
     * Get a value based on its index.
     *
     * @param index the position of requested value
     * @return value of element at index
     */
    public T get(int index) throws IndexOutOfBoundsException {
        Link searchValueObject = head;
        if(index == 0 && searchValueObject == null){
            throw new IndexOutOfBoundsException("IndexOutOfBoundException");
        }
        for (int i = 0; i < index; i++) {
            if(searchValueObject.getNext() == null){
                throw new IndexOutOfBoundsException("IndexOutOfBoundException");
            }
            searchValueObject = searchValueObject.getNext();
        }
        return (T) searchValueObject.getValue();  // HERE frage: warum braucht das (T)?
    }

    /**
     * Returns the zero-based index of the first occurrence of a value in the list.
     *
     * @param number value to be searched
     * @return Index of 'number' if it's in the list, otherwise -1;
     */
    public int indexOf(int number) {
        int counter = -1;
        Link objectSearchedValue = head;
        while(objectSearchedValue != null){
            counter++;
            if((T)((Integer) number) == objectSearchedValue.getValue()){    // HERE: Warum geht das nicht?
                break;
            }
            objectSearchedValue = objectSearchedValue.getNext();
        }
        if(objectSearchedValue == null){
            counter = -1;
        }
        return counter;
    }

    /**
     * Inserts a value at an index into the array shifting elements if necessary.
     *
     * @param index  Position of the new element
     * @param number Value to be inserted.
     */
    public void insert(int index, int number) throws IndexOutOfBoundsException{
        Link insertValue = new Link(number);
        Link previousValue = head;
        Link afterValue = null;
        if(index < 0){
            throw new IndexOutOfBoundsException("IndexOutOfBoundException");
        }
        if(index == 0){
            afterValue = previousValue;
            head = insertValue;
            head.setNext(afterValue);
        }
        for (int i = 1; i < index; i++) {
            if(previousValue.getNext() == null){
                throw new IndexOutOfBoundsException("IndexOutOfBoundException");
            }
            previousValue = previousValue.getNext();
            afterValue = previousValue.getNext();
        }
        if(index != 0) {
            if(afterValue == null && index == 1){
                afterValue = head.getNext();
            }
            insertValue.setNext(afterValue);
            previousValue.setNext(insertValue);
        }
    }

    /**
     * Returns with the amount of inserted nodes.
     *
     * @return Size of list.
     */
    public int size() {
        int sizeCounter = 0;
        if(head == null){
            return sizeCounter;
        }
        else{
            sizeCounter++;
            Link nodesBefore = head;
            while(nodesBefore.getNext() != null){
                sizeCounter++;
                nodesBefore = nodesBefore.getNext();
            }
        }
        return sizeCounter;
    }

    /**
     * Removes the element at 'index' from the array.
     *
     * @param index Position of value to be deleted.
     */
    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }

    @Override
    public String toString() {
        StringBuilder linkedList = new StringBuilder("[");
        if(head == null){
            linkedList.append("]");
            return linkedList.toString();
        }
        Link objectWithValue = head;
        while(objectWithValue != null){
            linkedList.append(objectWithValue.getValue());
            objectWithValue= objectWithValue.getNext();
            if(objectWithValue != null){
                linkedList.append(", ");
            }
        }
        linkedList.append("]");
        return linkedList.toString();
    }
}
