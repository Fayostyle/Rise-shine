class Solution {
    public int maximumGap(int[] nums) {
		int n = nums.length;
		int[] bucket = new int[n + 1];
		int[] max = new int[n + 1];
		int[] min = new int[n + 1];
		boolean[] hasNum = new boolean[n + 1];
		
		for(int num : nums){
			int index = getIndex(num);
			if(hasNum[index]) {
				max[index] = Math.max(max[index], num);
				min[index] = Math.min(min[index], num);
			} else {
				max[index] = num;
				min[index] = num;
				hasNum[index] = true;
			}
		}
   }
}