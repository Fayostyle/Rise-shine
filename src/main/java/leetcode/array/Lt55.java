class Lt55 {
	public boolean canJump(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return true;
		}
		
		int rightMost = 0;
		for(int i=0; i<nums.length; i++) {
			if(i <= rightMost) {
				rightMost = Math.max(rightMost, nums[i] + i);
				if(rightMost >= nums.length  - 1) {
					return true;
				}
			}
		}
		return false;
    }
}