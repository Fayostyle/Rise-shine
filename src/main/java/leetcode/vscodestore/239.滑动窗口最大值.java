/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 1 || k > nums.length) {
            throw new RuntimeException("error");
        }

        int[] res = new int[nums.length - k + 1];

        int[] help = new int[k];
        int max = nums[0];
        for(int j=0; j<k; j++) {
            help[j] = nums[j];
            if(nums[j] > max) {
                max = nums[j];
            }
        }
        res[0] = max;
        for(int i=1; i<=nums.length - k; i++) {
            if(k > 1 ){
            int helpIndex = (i -1) % k;
            help[helpIndex] = nums[i + k - 1];
            if(max < nums[i + k - 1]) {
                max = nums[i + k - 1];
            }
            res[i] = max;
        } else {
            res[i] = nums[i];
        }
        }
        return res;
    }
}
// @lc code=end

