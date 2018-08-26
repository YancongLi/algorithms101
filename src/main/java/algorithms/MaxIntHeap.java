package algorithms;

import java.util.Arrays;

public class MaxIntHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int leftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int rightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int parentIndex(int childIndex ) { return (childIndex - 1) / 2; }

    private boolean hasLeftChild(int index) { return leftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return rightChildIndex(index) < size; }
    private boolean hasParent(int index) { return parentIndex(index) >= 0; }

    private int leftChild(int index) { return items[leftChildIndex(index)]; }
    private int rightChild(int index) { return items[rightChildIndex(index)]; }
    private int parent(int index) { return items[parentIndex(index)]; }

    int extractMax() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];        // grab the max
        items[0] = items[size - 1]; // swap top and bottom
        size--;
        heapifyDown();              // reorder
        return item;                // return max
    }

    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public void insert(int item) {
        ensureCapacity();
        items[size] = item; // put in last spot
        size++;
        heapifyUp();
    }

    void heapifyUp() {
        int lastIndex = size - 1;       // start at last element
        // while my parents are less than me...
        while (hasParent(lastIndex) && parent(lastIndex) < items[lastIndex]) {
            swap(parentIndex(lastIndex), lastIndex);
            lastIndex = parentIndex(lastIndex); // walk upwards to next node
        }
    }

    void heapifyDown() {
        int index = 0; // start at the top

        // as long as I have children
        // note: Only need to check left because if no left, there is no right
        while (hasLeftChild(index)) {

            // take the larger of the two indexes
            int largerChildIndex = leftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                largerChildIndex = rightChildIndex(index);
            }

            // now compare

            // if I am bigger than the items of my two children...
            // then everything is good. I am sorted.
            if(items[index] > items[largerChildIndex]) {
                break;
            } else {
                //  we are still not in order - swap
                swap(index, largerChildIndex);
            }

            // then move down to larger child
            index = largerChildIndex;
        }
    }

    public void print() {
        for (int i=0; i < size; i++) {
            System.out.println(i + "[" + items[i] + "]" );
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }


}
