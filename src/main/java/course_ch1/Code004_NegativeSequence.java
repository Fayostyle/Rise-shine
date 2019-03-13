package course_ch1;

import javax.sound.midi.Soundbank;

public class Code004_NegativeSequence {
    public static void selectNegetive(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        selectNegetive(arr, 0, arr.length - 1);
    }

    public static void selectNegetive(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        selectNegetive(arr, l, mid);
        selectNegetive(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;

        while (p1 <= mid && p2 <= r) {

            for (int t = p1; t <= mid + 1 && arr[t] > arr[p2]; t++) {
                System.out.println(arr[t] + "," + arr[p2]);
            }

            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int s = 0; s < help.length; s++) {
            arr[s + l] = help[s];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,2};
        selectNegetive(arr);
        Code001_SortSolution.printArr(arr);
    }
}
