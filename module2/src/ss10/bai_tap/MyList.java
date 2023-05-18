package ss10.bai_tap;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        if (size >= elements.length) {
            int newLength = elements.length * 2;
            E[] newElements = (E[]) new Object[newLength];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
    public void add(E element) {
        ensureCapa();
        elements[size] = element;
        size++;
    }
    public void add(int index, E element) {
        ensureCapa();
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
            elements[index] = element;
            size++;
        }
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + "out of bounds");
        }
    }

    public E remove(int index) {
        checkIndex(index);
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
            elements[size - 1] = null;
            size--;
        }
        return element;
    }

    public boolean isEmpty() {
        if (elements != null) {
            for (Object element : elements) {
                if (element != null) {
                    return true;
                }
            }
        }
        return false;

    }

    public int size() {
        return size;
    }

    public E[] clone() {
        E[] newElement = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newElement[i] = (E) elements[i];
        }
        return newElement;
    }

    public boolean contains(E o) {
        for (E e : (E[]) elements) {
            if (e == o) {
                return true;
            }
        }
        return false;
    }

    public void ensureCapacity(int minCapacity) {
        if (elements.length == minCapacity) {
            E[] newElements = (E[]) (new Object[elements.length * 2]);
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    public E get(int i) {
        if (i < 0 || i >= size) {
        }
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }
}

