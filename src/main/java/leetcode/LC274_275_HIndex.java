package leetcode;

import java.util.Arrays;

public class LC274_275_HIndex {

    public int hIndex1(int[] citations) {
        if (citations == null) {
            return 0;
        }
        Arrays.sort(citations);

        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            h = Math.max(h, Math.min(citations.length - i, citations[i]));
        }
        return h;
    }

    public int hIndex2(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);
        int l = 0;
        int r = citations.length - 1;
        int h = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] >= citations.length - mid) {
                r = mid - 1;
                h = citations.length - mid;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

    public int hIndex3(int[] num) {
        int[] help = new int[num.length + 1];
        for(int i = 0; i<num.length; i++) {
            if(num[i] >= num.length) {
                num[num.length]++;
            } else {
                help[num[i]]++;
            }
        }
        for(int j=help.length - 1; j>=0; j++) {
            if(help[j] >= j) {
                return j;
            }
            help[j-1] += help[j];
        }
        return 0;
    }
}
