class Lt41 {
    public int firstMissingPositive(int[] nums) {
		for(int i=0; i<nums.length; ){
            if(nums[i] > 0 && nums[i] <= nums.length && i+1!=nums[i] && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
			} else {
                i++;
            }
		}
        int i=0;
        for(;i<nums.length;i++){
            if(i+1 != nums[i]) {
                return i+1;
            }
        }
		return i+1;
    }
}