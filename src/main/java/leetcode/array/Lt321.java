class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

   		int m = nums1.length;
		int n = nums2.length;
		
		int[] seq1;
		int[] seq2;
		int[] tmp;
		int[] ans = new int[k];
		//i 从nums1中取得数字个数
		for(int i=Math.max(0, k - n); i <= Math.min(k, m); i++) {
			seq1 = maxSequence(nums1, i);
			seq2 = maxSequence(nums2, k - i);
			tmp = mergeSequence(seq1, seq2);
			if(compare(tmp, ans)) {
				ans = tmp;
			}
		}
		return ans;
	}
	
	public int[] maxSequence(int[] nums, int k) {
		int[] ans = new int[k];
		if(k == 0) {
			return ans;
		}
		if(k >= nums.length) {
			return nums;
		}
		int drop = nums.length - k;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<nums.length; i++) {
			while(!stack.isEmpty() && nums[i] > stack.peek() && drop-- > 0) {
				stack.pop();
			}
			stack.push(nums[i]);
		}
		while(stack.size() > k) {
			stack.pop();
		}
		for(int i=k-1; i>=0; i--) {
			ans[i] = stack.pop();
		}
		return ans;
	}
	
	public int[] mergeSequence(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int[] ans = new int[l1 + l2];
		int i1 = 0, i2 = 0;
		for(int i=0; i<l1 + l2; i++) {
			int[] a1 = Arrays.copyOfRange(nums1, i1, l1);
			int[] a2 = Arrays.copyOfRange(nums2, i2, l2);
			if(compare(a1, a2)) {
				ans[i] = nums1[i1++];
			} else {
				ans[i] = nums2[i2++];
			} 
		}
		return ans;
	}
	
	public boolean compare(int[] nums1, int[] nums2) {
		int n = Math.min(nums1.length, nums2.length);
		for(int i=0; i<n; i++) {
			if(nums1[i] > nums2[i]) return true;
			if(nums1[i] < nums2[i]) return false;
			continue;
		}
		return nums1.length > nums2.length;
	}
	
}




/*
给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，
表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，
要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

说明: 请尽可能地优化你算法的时间和空间复杂度。

示例 1:

输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
示例 2:

输入:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
输出:
[6, 7, 6, 0, 4]
示例 3:

输入:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
输出:
[9, 8, 9]

*/



