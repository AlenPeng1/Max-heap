package example2;
public class Heap {
    public int[] heapArray;		// integer array to store the elements
    public int heapSize;		// current number of elements in the heap
    public int swaps;			// number of swaps performed during heap operations
    
// constructor 
    public Heap(int capacity) {
        heapArray = new int[capacity];
        heapSize = 0;
        swaps = 0;
    }
// add method
    public void add(int value) {
        if (heapSize == heapArray.length) {
            // if array is full, resize 
            return;
        }
        heapArray[heapSize] = value;
        heapSize++;

        // ensures that the new added element are in the correct position 
        int currentIndex = heapSize - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heapArray[currentIndex] > heapArray[parentIndex]) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
                swaps++;
            } else {
                break;
            }
        }
    }

    public void heapOptimalMethod(int[] values) {
        heapArray = values;
        heapSize = values.length;
        swaps = 0;

        // Perform down-heapify starting from the last non-leaf node
        int startIndex = (heapSize - 2) / 2;
        for (int i = startIndex; i >= 0; i--) {
            downHeapify(i);
        } 
    }

    public int remove() {
        if (heapSize == 0) {
            // Heap is empty
            return -1;
        }

        int root = heapArray[0];
        heapArray[0] = heapArray[heapSize - 1];
        heapSize--;

        // Perform down-heapify to restore the heap property
        downHeapify(0);

        return root;
    }

    public void downHeapify(int currentIndex) {
        int largestIndex = currentIndex;
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;

        if (leftChildIndex < heapSize && heapArray[leftChildIndex] > heapArray[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < heapSize && heapArray[rightChildIndex] > heapArray[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != currentIndex) {
            swap(currentIndex, largestIndex);
            downHeapify(largestIndex);
            swaps++;
        }
    }

    public void swap(int index1, int index2) {
        int temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }

    public int[] getHeapArray() {
        return heapArray;
    }
    
    public int getSwaps() {
        return swaps;
    }
}