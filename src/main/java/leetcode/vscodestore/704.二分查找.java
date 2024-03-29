/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int curr = nums[mid];
            if(curr == target) {
                return mid;
            } else if(curr > target) {
                right = mid - 1;
            } else if(curr < target) {
                left = mid + 1;
            }
        }

        return -1;
    }
}
// @lc code=end

