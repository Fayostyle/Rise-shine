class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
		int n = nums.length;
		int[] max = new int[n + 1];
		int[] min = new int[n + 1];
		boolean[] hasNum = new boolean[n + 1];
		
		int maxNum = Integer.MIN_VALUE;
		int minNum = Integer.MAX_VALUE;
		for(int value : nums) {
			maxNum = Math.max(value, maxNum);
			minNum = Math.min(value, minNum);
		}

        if(maxNum == minNum) return 0;
		
		for(int num : nums){
			int index = getIndex(num, maxNum, minNum, n);
			if(hasNum[index]) {
				max[index] = Math.max(max[index], num);
				min[index] = Math.min(min[index], num);
			} else {
				max[index] = num;
				min[index] = num;
				hasNum[index] = true;
			}
		}
		
		int maximum = 0;
		int preMax = max[0];
		for(int i=1; i<hasNum.length; i++) {
			if(hasNum[i]) {
				maximum = Math.max(maximum, min[i] - preMax);
				preMax = max[i];
			}
		}
		
		return maximum;
   }
   
   int getIndex(long num, long max, long min, int length) {
	   return (int)((num-min)  * length / (max - min));
   }
}