package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC220_ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2) {
            return false;
        }
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(Math.abs(nums[i]-nums[j]) <= t && Math.abs(j - i) < k) {
                    return true;
                }
            }
        }
        return false;
    }
}
