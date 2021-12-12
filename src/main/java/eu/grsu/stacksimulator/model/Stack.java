package eu.grsu.stacksimulator.model;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

public class Stack<E> implements Iterable<E> {
    private Object[] elementData;

    private int elementCount;

    public Stack() {
        elementData = new Object[10];
    }

    //  Implementing stack functions
    public E push(E item) {
        if (elementCount + 1 - elementData.length > 0)
            elementData = Arrays.copyOf(elementData, (int) (elementCount * 1.5));

        elementData[elementCount++] = item;

        return item;
    }

    public E pop() {
        E obj = peek();
        removeElementAt(elementCount - 1);

        return obj;
    }

    public E peek() {
        if (elementCount == 0)
            throw new EmptyStackException();
        return elementAt(elementCount - 1);
    }

    public boolean empty() {
        return elementCount == 0;
    }

    public int search(Object o) {
        int index = elementCount - 1;
        if (o == null) {
            for (int i = index; i >= 0; i--)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = index; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    public int size() {
        return elementCount;
    }

    public void removeElementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementData[--elementCount] = null;
    }

    @SuppressWarnings("unchecked")
    public E elementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }

        return (E) elementData[index];
    }

    //  Implementing Iterable interface
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        int cursor = 0;
        int lastRet = -1;

        public boolean hasNext() {
            return cursor != size();
        }

        public E next() {
            try {
                int i = cursor;
                E next = elementAt(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            try {
                removeElementAt(lastRet);
                if (lastRet < cursor)
                    cursor--;
                lastRet = -1;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        @SuppressWarnings("unchecked") final E[] elementData = (E[]) this.elementData;
        final int size = elementCount;
        for (int i = 0; i < size; i++) {
            action.accept(elementData[i]);
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(new Stack[]{this}, Spliterator.ORDERED);
    }
}