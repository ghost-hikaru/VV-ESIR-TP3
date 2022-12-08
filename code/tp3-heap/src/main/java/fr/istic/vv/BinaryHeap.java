package fr.istic.vv;


import java.util.Comparator;

class BinaryHeap<T> {
    private final Comparator<T> comparateur;
    private T[] heap;
    private int taille;

    public BinaryHeap(Comparator<T> comparator) {
        this.comparateur = comparator;
        this.taille = 0;
        this.heap = (T[]) new Object[20];
    }

    public T pop() {
        if (taille == 0) {
            return null;
        }
        T result = heap[0];
        heap[0] = heap[taille - 1];
        taille--;
        heapifyDown();
        return result;
    }

    public int count() {
        return taille;
    }

    public T peek() {
        if (!(taille == 0)) {
            return heap[0];
        }
        return null;
    }

    public void push(T element) {
        if (taille == heap.length) {
            T[] newHeap = (T[]) new Object[taille * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
        heap[taille] = element;
        taille++;
        heapifyUp();
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < taille;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < taille;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private T getRightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    private T getLeftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && comparateur.compare(getRightChild(index), getLeftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (comparateur.compare(heap[index], heap[smallerChildIndex]) < 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = taille - 1;
        while (hasParent(index) && comparateur.compare(heap[index], heap[getParentIndex(index)]) < 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void swap(int index, int parentIndex) {
        T tmp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = tmp;
    }
}