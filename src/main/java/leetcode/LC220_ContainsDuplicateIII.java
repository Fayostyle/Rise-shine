package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC220_ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k<=0 || t<0) {
            return false;
        }
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j - i <= k && j<nums.length; j++) {
                if(Math.abs(Long.valueOf(nums[i])-Long.valueOf(nums[j])) <= t ) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2147483647};
        int k = 1;
        int t = 2147483647;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
