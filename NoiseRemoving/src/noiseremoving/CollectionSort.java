package noiseremoving;

/**
 *
 * @author Nathan
 */

// Is quick sort the best way of finding median? Why? 
//
// Quick sort is not the best way of finding the median. 
// This is because Quick sort is good at general sorting with the average-case time complexity of O(n log n),
// but has unecessary partitioning steps for finding the median.
// There are more efficient algorithms specifically for median finding.
//
// What is another good way of finding median? Please provide your explanation.
// 
// A differemt way is using the algorithm called "Median of Medians" algorithm.
// Its a variation of the Quick select algorithm and is used as an efficient algorithm for finding the median.
// This algorithm gurantees a linear time complexity with a worst case time complexity of O(n) good for large data sets.
// Turns array into groups of 5 elements and then recursively does the processing until it finds the median.
// For efficient median computing this algorithm is better than the Quick sort algorithm.


public class CollectionSort<E extends Comparable<E>> 
{
    // Array to be sorted
    private E[] array;

    public void setArray(E[] array) 
    {
        // Set the array to be sorted
        this.array = array;
    }

    public void quickSort() 
    {
        if (array == null || array.length == 0) 
        {
            // Base case: Empty or null array, nothing to sort
            return;
        }
        // Start quicksort with the entire array
        quickSort(0, array.length - 1);
    }

    private void quickSort(int low, int high) 
    {
        // Left pointer
        int i = low;

        // Right pointer
        int j = high;

        // Choose pivot element
        E pivot = array[low + (high - low) / 2];

        while (i <= j) {
            // Find element on the left that should be on the right side
            while (array[i].compareTo(pivot) < 0) 
            {
                i++;
            }

            // Find element on the right that should be on the left side
            while (array[j].compareTo(pivot) > 0) 
            {
                j--;
            }

            if (i <= j) 
            {
                // Swap elements
                swap(i, j);
                i++;
                j--;
            }
        }

        // Recursively sort the two sub-arrays
        if (low < j) 
        {
            // Sort the left sub-array
            quickSort(low, j);
        }
        if (i < high) 
        {
            // Sort the right sub-array
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) 
    {
        // Temporary variable to hold the element at index i
        E temp = array[i];

        // Assign element at index j to index i
        array[i] = array[j];

        // Assign the temporary element to index j
        array[j] = temp;
    }
}