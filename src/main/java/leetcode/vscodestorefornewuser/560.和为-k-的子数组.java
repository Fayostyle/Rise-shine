/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 *
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (45.38%)
 * Likes:    1797
 * Dislikes: 0
 * Total Accepted:    291.7K
 * Total Submissions: 643K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * 
 * 
 */

// @lc code=start
class Solution {
/*     public int subarraySum(int[] nums, int k) {
        int[] preNum = new int[nums.length + 1];
        for(int i=1; i<=nums.length; i++) {
            preNum[i] = preNum[i-1] + nums[i-1];
        }
        
        int res = 0;
        for(int i=1; i<preNum.length; i++) {
            for(int j=0; j<i; j++) {
                if(preNum[i] - preNum[j] == k) {
                    res++;
                }
            }
        }

        return res;
    } */

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int res = 0, sum0_i = 0;
        preSum.put(0, 1);
        for(int i=0; i<nums.length; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if(preSum.containsKey(sum0_j)) {
                res += preSum.get(sum0_j);
            }
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }

        return res;
    } 
}
// @lc code=end

