package course_ch1;

public class Code005_LessInleftBiggerinright {
    public static void halfSort(int[] arr, int num) {
        int p = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] <= num) {
                //当前数和小于等于区域的后一个数交换，并且小于等于区域向左扩张一位
                Code001_SortSolution.swap(arr, i, p + 1);
                p++;
            }
        }
    }

    public static void halfSort2(int[] arr, int num) {
        int p1 = -1;
        int p2 = arr.length;
        int i = 0;
        while(i < p2){
            if(arr[i] < num) {
                Code001_SortSolution.swap(arr, i , p1+1);
                p1++;
                i++;
            } else if(arr[i] > num) {
                Code001_SortSolution.swap(arr, i , p2-1);
                p2--;
            } else {
                i++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {5,4,5,6,7,8,9,4,2};
        halfSort(arr, 5);
        Code001_SortSolution.ptintArr(arr);
    }
}
