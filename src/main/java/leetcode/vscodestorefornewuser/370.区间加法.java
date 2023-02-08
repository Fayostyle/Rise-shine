/*
 * 假设你有一个长度为n的数组，初始情况下所有的数字均为0，你将会被给出k个更新的操作。
 *其中，每个操作会被表示为一个三元数组：[startIndex, endIndex, inc]，你需要将子数组
 * A[startIndex...endIndex]（包括startIndex和endIndex）增加inc
 *请返回k次操作后的数组 
 * 
 * 
 * 示例 ：
 * 
 * 
 * 输入：length=5, update = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出：[-2,0,3,5,3]
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    int[] getModifiedArray(int length, int[][] updates) {
        int array = new int[length];

        //构造差分数组
        int[] diff = diff(array);
        int k = updates.length;
        for(int i=0; i<k; i++) {
            increment(updates[i][0], updates[i][1], updates[i][2], diff);
        }
        return result(diff);

    }

    //构造差分数组
    int[] diff(int[] nums) {
        int[] diff = new int[nums.length];
        diff[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
        return diff;
    }

    //给闭区间[i,j]增加val， 可以是负数
    void increment(int i, int j, int val, int[] diff) {
        diff[i] += val;
        if(j + 1 < diff.length) {
            diff[j+1] -= val;
        }
    }

    //获取修改后的数组
    int[] result(int[] diff) {
        int[] nums = new int[diff.length];
        nums[0] = diff[0];
        for(int i=1; i<nums.length; i++) {
            nums[i] = nums[i-1] + diff[i];
        }

        return nums;
    }
}
// @lc code=end

