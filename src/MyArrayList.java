import java.util.Arrays;


/**
 * This is modified/simplified/lightweight version of ArrayList class.
 * The class contains add(), get(), remove(), size() and isEmpty() methods.
 * As elements are added to an ArrayList, its capacity grows automatically.
 */

public class MyArrayList<E> {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer.
     */
    private Object[] elementData;


    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size = 0;


    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  initialCapacity  the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.elementData = new Object[initialCapacity];
        }
        else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }



    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public Object get(int index) {
        if (index < size) {
            return elementData[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     */
    public void add(E element) {
        if (elementData.length - size == 1) {
            increaseListSize();
        }
        elementData[size++] = element;
    }

    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException if index is negative or
     *          index is greater than size
     */
    public void add(int index, E e) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);

        if (elementData.length - size == 1) {
            increaseListSize();
        }

        elementData[index] = e;
        size++;
    }


    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if index is negative or
     *          index is greater than size (i.e., not in a possible range)
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);

        E oldValue = (E) elementData[index];
        elementData[index] = null;      // clear to let GC do its work
        int tempIndex = index;
        while (tempIndex < size) {
            elementData[tempIndex] = elementData[tempIndex + 1];
            elementData[tempIndex + 1] = null;
            tempIndex++;
        }
        size--;
        return oldValue;
    }


    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }


    /**
     * Returns <tt>true</tt> if this list contains no elements.
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }


    private void increaseListSize() {
        elementData = Arrays.copyOf(elementData, elementData.length * 2);
    }


}
