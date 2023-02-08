/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 *
 * https://leetcode.cn/problems/car-pooling/description/
 *
 * algorithms
 * Medium (52.61%)
 * Likes:    227
 * Dislikes: 0
 * Total Accepted:    65.5K
 * Total Submissions: 124.6K
 * Testcase Example:  '[[2,1,5],[3,3,7]]\n4'
 *
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * 
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i
 * 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * 
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //车站数量最多是1001  0 <= fromi < toi <= 1000
        int[] nums = new int[1001];
        Diffrence diffrence = new Diffrence(nums);
        for(int[] trip : trips) {
            int val = trip[0];
            int i = trip[1];
            //trip[2] 站已经下车 所以-1
            int j = trip[2] - 1;
            diffrence.increment(i, j, val);
        }
        int[] res = diffrence.result();
        System.out.println(Arrays.toString(res));
        for(int i=0; i<res.length; i++) {
            if(res[i] > capacity) {
                return false;
            }
        }

        return true;
    }
}

class Diffrence {
    int[] diff;
    public Diffrence(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

      //给闭区间[i,j]增加val， 可以是负数
    void increment(int i, int j, int val) {
        diff[i] += val;
        if(j + 1 < diff.length) {
            diff[j+1] -= val;
        }
    }

    //获取修改后的数组
    int[] result() {
        int[] nums = new int[diff.length];
        nums[0] = diff[0];
        for(int i=1; i<nums.length; i++) {
            nums[i] = nums[i-1] + diff[i];
        }

        return nums;
    }
}
// @lc code=end

