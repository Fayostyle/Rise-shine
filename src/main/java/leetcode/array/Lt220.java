class Lt220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(k == 0 || t < 0 || nums == null || nums.length == 0) {
			return false;
		}
		
		TreeSet<Integer> set = new TreeSet<>();
		for(int i=0; i<nums.length; i++) {
			Integer b = set.ceiling(nums[i]);
			if(b != null && b - nums[i] <= t) return true;
			
			Integer s = set.floor(nums[i]);
			if(s != null && nums[i] - s <= t) return true;
			
			s.add(nums[i]);
			
			if(s.size() >k) {
				s.remove(nums[i-k);
			}
		}
		return false;
    }

}