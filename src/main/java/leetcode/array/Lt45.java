class Lt45 {
	public int jump(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return 0;
		}
		
		int cur = 0;
		int count = 1;
		while(cur <= nums.length - 1) {
			int last = cur;
			int curMost = nums[cur] + cur;

			for(int i=cur+1; i<=nums[cur] + cur && i < nums.length; i++) {
			
				if(nums[i] + i - cur > curMost) {
					curMost = nums[i] + i - cur;
					last = i;
				}
			}
			cur = last;
			count++;
			
			if(cur + nums[cur] >= nums.length - 1) {
				return count;
			}
		}
		return count;
	
    }
	
	public int jump2(int[] nums) {
		int max = 0;
		int step = 0;
		int n = nums.length;
		int end = 0;
		for(int i=0; i<n-1; i++) {
			max = Math.max(max, nums[i] + i);
			if(i == end) {
				step++;
				end = max;
			}
		}
		return step;
	}
}

