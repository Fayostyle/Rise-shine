package course_ch1;

import java.util.Arrays;

public class Solution {

    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int end = arr.length - 1; end > 0; end--) {
            for(int j=0; j < end; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j+1, j);
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++) {
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /** 对数器的使用 **/
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
            insertSort(arr2);
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
        insertSort(arr);
        ptintArr(arr);
    }
}
