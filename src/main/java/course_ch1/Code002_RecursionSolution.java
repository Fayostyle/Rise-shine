package course_ch1;

public class Code002_RecursionSolution {

    public static int getMax(int[] arr) {
        if(arr == null || arr.length < 1) {
            throw new RuntimeException("arr不合法");
        }
        return getMax(arr, 0, arr.length - 1);
    }
    public static int getMax(int[] arr, int l, int r) {
        if(l == r) {
            return arr[l];
        }
        int mid = l + (r - l) / 2;
        int leftMax = getMax(arr, l, mid);
        int rightMax = getMax(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = Code001_SortSolution.generateRandomArray(10, 1000);
        int max = getMax(arr);
        Code001_SortSolution.printArr(arr);
        System.out.println(max);
    }
}
