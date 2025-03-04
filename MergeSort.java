public class MergeSort {
    public static void main(String[] args) {
        int[] a = {1,6,8,20,2,3,7,12};
        int start = 0;
        int end = a.length;
        int mid = (start + end) / 2; // Calculate mid properly
        int k = 0;
        int size = end - start;
        int i = start;
        int j = mid;
        int[] temp = new int[size];

        // Merging two sorted halves 
        while (i < mid && j < end) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // Copy remaining elements from first half
        while (i < mid) {
            temp[k++] = a[i++];
        }

        // Copy remaining elements from second half
        while (j < end) {
            temp[k++] = a[j++];
        }

        // Copy sorted elements back to original array
        for (int l = 0; l < size; l++) {
            a[start + l] = temp[l];
        }

        // Print the sorted array
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}