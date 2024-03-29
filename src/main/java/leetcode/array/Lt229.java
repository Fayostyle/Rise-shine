/**

给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。

示例 1:

输入: [3,2,3]
输出: [3]
示例 2:

输入: [1,1,1,3,3,2,2,2]
输出: [1,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
class Lt229 {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		
		int cand1 = nums[0], count1 = 0;
		int cand2 = nums[0], count2 = 0;
		for(int num : nums) {
			if(cand1 == num) {
				count1++;
				continue;
			}
			if(cand2 == num) {
				count2++;
				continue;
			}
			
			if(count1 == 0) {
				cand1 = num;
				count1++;
				continue;
			}
			if(count2 == 0) {
				cand2 = num;
				count2++;class Solution {
    public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		
		int cand1 = nums[0], count1 = 0;
		int cand2 = nums[0], count2 = 0;
		for(int num : nums) {
			if(cand1 == num) {
				count1++;
				continue;
			}
			if(cand2 == num) {
				count2++;
				continue;
			}
			
			if(count1 == 0) {
				cand1 = num;
				count1++;
				continue;
			}
			if(count2 == 0) {
				cand2 = num;
				count2++;
				continue;
			}
            count1--;
            count2--;
		}
		count1 = 0;
		count2 = 0;
		for(int num :nums) {
			if(num == cand1) count1++;
			else if(num == cand2) count2++;
		}
		
		if(count1 > nums.length / 3) res.add(cand1);
		if(count2 > nums.length / 3) res.add(cand2);
		return res;
    }
}