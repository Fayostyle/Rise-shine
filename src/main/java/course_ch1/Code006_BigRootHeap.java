package course_ch1;

public class Code006_BigRootHeap {
    public static void genBigRootHeap(int[] num) {
        for(int i = 1; i < num.length; i++) {
            int cur = i;
            while(cur > 0 && num[cur] > num[(cur-1) / 2]) {
                Code001_SortSolution.swap(num, cur, (cur-1) / 2);
                cur = (cur-1) / 2;
            }
        }
    }
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Code001_SortSolution.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,1,3,6,0,4};
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        genBigRootHeap(arr);
        Code001_SortSolution.printArr(arr);
    }
}
