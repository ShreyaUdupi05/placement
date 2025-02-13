package Day_4;
public class NextGreaterElement {
    public static void findNextGreater(int[] arr, int[] result, int index) {
        if (index == arr.length) return; // Base case

        result[index] = -1; // Default value
        for (int j = index + 1; j < arr.length; j++) {
            if (arr[j] > arr[index]) {
                result[index] = arr[j];
                break;
            }
        }

        findNextGreater(arr, result, index + 1); // Recursive call
    }

    public static int[] nextGreaterElements(int[] arr) {
        int[] result = new int[arr.length];
        findNextGreater(arr, result, 0);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        System.out.println(java.util.Arrays.toString(nextGreaterElements(arr))); // [8, -1, 1, 3, -1]
    }
}
