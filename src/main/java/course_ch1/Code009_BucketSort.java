package course_ch1;

public class Code009_BucketSort {
    public static void bucketSort(int[] num) {
        if(num == null || num.length < 2) {
            return;
        }
        int[] help = new int[11];
        for(int i=0; i<num.length; i++) {
            int value = num[i];
            help[value]++;
        }
        int cur = 0;
        for(int j=0; j<help.length; j++) {
            while(help[j]-- > 0) {
                num[cur++] = j;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,0,3,2,1,0};
        bucketSort(num);
        Code001_SortSolution.printArr(num);
    }
}
