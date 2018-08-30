package algorithms;

class MergeSort {

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int leftPointer, int rightPointer) {
        System.out.println("splitting l r: " + leftPointer + " " + rightPointer);
        if (leftPointer < rightPointer) {
            // Find the middle point
            int middlePointer = (leftPointer + rightPointer) / 2;

            // Sort first and second halves -> recursive call
            sort(arr, leftPointer, middlePointer);
            sort(arr, middlePointer + 1, rightPointer);

            // Merge the sorted halves
            merge(arr, leftPointer, middlePointer, rightPointer);
        }
    }

    // Merges two subArrays of arr[].
    // First subArray is arr[l..m]
    // Second subArray is arr[m+1..r]
    private void merge(int arr[], int leftPointer, int middlePointer, int rightPointer) {
        System.out.println("merge l m r: " + leftPointer + " " + middlePointer + " " + rightPointer);

        // Find sizes of two subArrays to be merged
        int size1 = middlePointer - leftPointer + 1;
        int size2 = rightPointer - middlePointer;

        /* Create temp arrays */
        int L[] = new int[size1];
        int R[] = new int[size2];

        /* Copy data to temp arrays */
        for (int i = 0; i < size1; ++i) {
            L[i] = arr[leftPointer + i];
        }
        for (int j = 0; j < size2; ++j) {
            R[j] = arr[middlePointer + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subArrays
        int i = 0, j = 0;

        // Initial index of merged subArray array
        int k = leftPointer;
        while (i < size1 && j < size2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < size1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < size2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        System.out.println("After merge");
        printArray(arr);
    }

    // Pros: Pretty efficient sorting algorithm - O(n log(n))

    // Cons: Takes up a bit more space (as you are copying and duplicating contents of array)

    /* This code is contributed by Rajat Mishra */
}