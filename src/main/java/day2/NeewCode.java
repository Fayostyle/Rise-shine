package day2;

import java.util.Arrays;

public class NeewCode {
    public static void bubbleSort(int num[]) {
        if(num == null || num.length < 2) return;
        for(int end = num.length - 1; end >= 0; end--) {
            for(int i=0; i<end; i++) {
                if(num[end] < num[i]) {
                    swap(num, i, end);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public static void   selectorSort(int[] num) {
        if(num == null || num.length < 2) return;
        for(int i=0; i<num.length; i++) {
            for(int j=i+1; j<num.length; j++) {
                if(num[j] < num[i]) {
                    swap(num, i, j);
                }
            }
        }
    }

    public static void insertSort(int[] num) {
        if(num == null || num.length < 2) return;
        for(int i=1; i<num.length; i++) {
            for(int j = i - 1; j>=0; j--) {
                if(num[j] > num[j+1]) {
                    swap(num, j, j+1);
                }
            }
        }
    }

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] num, int l, int r) {
        if(l == r) {
            return;
        }
            int mid = l + (r - l) / 2;
            mergeSort(num, l, mid);
            mergeSort(num, mid+1, r);
            merge(num, l, mid, r);
    }

    public static void merge(int[] num, int l, int mid, int r){
        int[] help = new int[r-l+1];
        int i = 0;
        int left = l;
        int right = mid + 1;
        while(left<=mid && right<=r) {
            help[i++] = num[left] > num[right] ? num[right++] : num[left++];
        }
        while(left <= mid) {
            help[i++] = num[left++];
        }
        while(right <= r) {
            help[i++] = num[right++];
        }
        for(int t=0; t<help.length; t++) {
            num[t + l] = help[t];
        }

    }

    public static void comparator(int[] num) {
        Arrays.sort(num);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)(Math.random() *(maxSize + 1))];
        for(int i=0; i<arr.length; i++) {
            arr[i] = (int) ((int) (Math.random() * (maxValue + 1)) - maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        if(arr == null) {
            return null;
        }
        int[] copy = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null) || arr1.length != arr2.length) {
            return false;
        }
        if(arr1 == null && arr2 == null) {
            return true;
        }

        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                    return false;
            }
        }
        return true;
    }

    public static void ptintArr(int[] arr) {
        if(arr == null) {
            return;
        }
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        boolean succeed = true;
        for(int i=0; i<testTime; i++) {
            int[] arr = generateRandomArray(10, 20);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);

            comparator(arr1);
            mergeSort(arr2);
            if(!isEqual(arr1, arr2)) {
                succeed = false;
                ptintArr(arr);
                ptintArr(arr1);
                ptintArr(arr2);
                break;
            }
        }
        System.out.println(succeed ? "nice!" : "fuck");

        int[] arr = generateRandomArray(10, 20);
        comparator(arr);
        ptintArr(arr);
        mergeSort(arr);
        ptintArr(arr);
    }
}
