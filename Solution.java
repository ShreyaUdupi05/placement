package Day_5;
import java.util.Arrays;

public class Solution {
 // Function to find the k-th closest element using Quickselect
    public static int findKthClosest(int[] readings, int target, int k) {
        // Calculate the distance from the target for each element
        int[] distances = new int[readings.length];
        for (int i = 0; i < readings.length; i++) {
            distances[i] = Math.abs(readings[i] - target);
        }
        // Use Quickselect to find the k-th smallest distance
        int kthDistance = quickSelect(distances, 0, distances.length - 1, k - 1);
        // Collect all elements with the k-th smallest distance
        int[] closestElements = Arrays.stream(readings)
                                      .filter(num -> Math.abs(num - target) <= kthDistance)
                                      .toArray();
        // Sort the closest elements and return the k-th closest
        Arrays.sort(closestElements);
        return closestElements[k - 1];
    }
    // Quickselect implementation
    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    // Partition function used in Quickselect
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] readings1 = {72, 75, 68, 80, 74};
        int target1 = 73;
        int k1 = 2;
        System.out.println(findKthClosest(readings1, target1, k1)); // Output: 74
    }
}
