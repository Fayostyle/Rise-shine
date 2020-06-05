class Lt169 {
    public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		
		Map.Entry<Integer, Integer> r = null;
		for(Map.Entry entry<Integer, Integer> : map.entrySet()) {
			if(r == null || entry.getValue() > r.getValue()) {
				r = entry;
			}
		}
		return r.getKey();
    }
	
	
	public int majorityElement2(int[] nums) {
		if(nums == null || nums.length == 0) {
			return null;
		}
		int aim = nums[0];
		int count = 1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == aim) {
				count++;
			} else {
				if(count == 0) {
					aim = nums[i];
					count = 1;
				} else {
					count--;
				}
			}
		}
		return aim;
	}

}