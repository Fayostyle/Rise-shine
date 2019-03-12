package course_ch1;

public class Code004_LessInleftBiggerinright {
    public static void halfSort(int[] arr, int num) {
        int p = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= num) {
                //当前数和小于等于区域的下一个数交换，并且小于等于区域向左扩张一位
                Code001_SortSolution.swap(arr, i, p + 1);
                p++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,1,2,3};
        halfSort(arr, 4);
        Code001_SortSolution.ptintArr(arr);
    }
}
