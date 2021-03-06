package pkg;

import java.util.ArrayList;
import java.util.List;

public class Sort {
	
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 
	// runtime O(n^2)
	public void bubbleSort(List<Integer> arr) {
		double switches = 0;
		
		double startTime = System.nanoTime();

		for(var i = 0; i < arr.size(); i++) {
			for(var j = 0; j < arr.size() - 1; j++) {
				if(arr.get(j) > arr.get(j+1)) {
					int tmp = arr.get(j);
					arr.set(j, arr.get(j+1));
					arr.set(j+1,  tmp);
					switches++;
					}
			}
		}
		double endTime = System.nanoTime();

		double duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
		System.out.println("Bubblesort took " + duration/1000000000 + " seconds to sort " + arr.size() + " random integers.");
		System.out.println("Number of switches: " + (int)switches);
	}
}
