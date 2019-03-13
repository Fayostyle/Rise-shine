package course_ch1;

public class Code003_MinSum {
    public static int mergeSort(int[] arr, int l, int r){
        if(l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;

        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int mergeSort(int[] arr) {
        if(arr == null) {
            throw new RuntimeException(("arr为空"));
        }
        if(arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }
    public static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while(p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while(p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while(p2 <= r) {
            help[i++] = arr[p2++];
        }

        for(int cur=0; cur<help.length; cur++) {
            arr[l + cur] = help[cur];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = Code001_SortSolution.generateRandomArray(6, 10);
        int[] arr2 = {1,3,4,2,5};
        Code001_SortSolution.printArr(arr);
        System.out.println(mergeSort(arr));
    }
}
