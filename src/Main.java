import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {874, 219, 597, 90, 668, 725, 203, 269, 739, 116, 367, 532, 279, 500, 790, 142, 832, 989, 572, 670, 83, 540, 849, 66, 709, 947, 945, 593, 602, 152};

        System.out.println("Args = " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Args = " + Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, left, center);
            mergeSort(arr, center+1, right);
            merge(arr, left, center, right);
        }
    }

    private static void merge(int[] arr, int left, int center, int right) {
        int[] temp = new int[right - left + 1];
        int i = left; // index of the first sub-array
        int j = center + 1; // index of the second sub-array
        int k = 0; // indice per l'array temporaneo

        // Merge the two ordered array into a temp array
        while (i <= center && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy any remaining elements from the first sub-array
        while (i <= center) {
            temp[k++] = arr[i++];
        }

        // Copy any remaining elements from the second sub-array
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy elements from the temp array to the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }
}
