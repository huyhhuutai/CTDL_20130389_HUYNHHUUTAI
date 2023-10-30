package Task1;

import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
		this.size = 0;
	}

	public void growSize() {
		int newCapacity = elements.length * 2;
		E[] newElements = (E[]) new Object[newCapacity];
		System.arraycopy(elements, 0, newElements, 0, size);
		elements = newElements;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		return elements[i];
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		E oldValue = elements[i];
		elements[i] = e;
		return oldValue;
	}

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size++] = e;
		return true;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if (size == elements.length) {
			growSize();
		}
		System.arraycopy(elements, i, elements, i + 1, size - i);
		elements[i] = e;
		size++;
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		E removedValue = elements[i];
		System.arraycopy(elements, i + 1, elements, i, size - i - 1);
		elements[size - 1] = null; // Clear the last element
		size--;
		return removedValue;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (o == null ? elements[i] == null : o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public E[] toArray() {
		E[] array = (E[]) new Object[size];
		System.arraycopy(elements, 0, array, 0, size);
		return array;
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> cloneList = new MyArrayList<>(elements.length);
		cloneList.size = size;
		System.arraycopy(elements, 0, cloneList.elements, 0, size);
		return cloneList;
	}

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (o == null ? elements[i] == null : o.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (o == null ? elements[i] == null : o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (e == null ? elements[i] == null : e.equals(elements[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	public void sort(Comparator<E> c) {
		}
}
