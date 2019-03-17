package course_ch1;

import java.util.Arrays;

public class Code011_MacGap {
    public static int maxGap(int[] num) {
        if(num == null || num.length < 2) {
            return 0;
        }

        int len = num.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<len; i++) {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }

        if(min == max) {
            return 0;
        }

        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];
        int bid = 0;
        for(int i=0; i<len; i++) {
            bid = bucket(num[i], min, max, len);
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], num[i]) : num[i];
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], num[i]) : num[i];
            hasNum[bid] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        for(int i=1; i<=len; i++) {
            if(hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;

    }

    public static int bucket(long num, long min, long max, int len) {
        return (int) ((num - min) * len / (max - min));
    }


    //for test
    public static int getMaxGap(int[] num) {
        int[] newarr = Arrays.copyOf(num, num.length);
        Arrays.sort(newarr);
        int res = 0;
        for(int i=1; i<newarr.length; i++) {
            res = Math.max(res, newarr[i] - newarr[i-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        boolean err = false;
        while(testTime-- > 0) {
            int[] num = Code001_SortSolution.generateRandomArray(100, 100);
            if(maxGap(num) != getMaxGap(num)) {
                System.out.println(maxGap(num) + "," + getMaxGap(num));
                Code001_SortSolution.printArr(num);
                err = true;
                break;
            }
        }
        System.out.println(err ? "fuck" : "nice");
    }
}
