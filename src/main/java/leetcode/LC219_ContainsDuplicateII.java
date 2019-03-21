package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC219_ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                min = Math.min(min, i - map.get(nums[i]));
            }
            map.put(nums[i], i);
        }
        return min > k ? false : true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
