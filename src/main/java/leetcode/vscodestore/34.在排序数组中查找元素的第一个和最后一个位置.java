/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBuount(nums, target), rightBound(nums, target)};

    }

    public int leftBuount(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while(left < right) {
            int mid = left + (right - left) / 2;

            int curr = nums[mid];

            if(curr == target) {
                right = mid;
            } else if(curr < target) {
                left = mid + 1;
            
            } else if(curr > target) {
                right = mid;
            }
        }
        if (right == nums.length) return -1;

        return nums[right] == target ? right : -1;
    }


    public int rightBound(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while(left < right) {
            int mid = left + (right - left) /2;
            int curr = nums[mid];

            if(curr == target) {
                left = mid + 1;
            } else if(curr < target) {
                left = mid + 1;
            } else if(curr > target) {
                right = mid;
            }
        }
        if (left == 0) return -1;
        return nums[left-1] == target ? left - 1 : -1;
    }
}
// @lc code=end

