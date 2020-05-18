class Lt80 {
	public int removeDuplicates(int[] nums) {
		if(nums == null ||nums.length == 0) {
			return 0;
		}
		
		if(nums.length == 1 || nums.length == 2) {
			return nums.length;
		}
		
		int count = 1, length = nums.length;
		for(int i=1; i<length; ) {
			if(nums[i] == nums[i-1]) {
				if(count > 1) {
					removeElement(arr, i);
					length--;
				} else{
					count++;
					i++;
				}
			} else {
				count = 1;
				i++;
			}
		}
		return length;
    }
	
	public void removeElement(int[] arr, int index) {
		for(int i=index+1; i<arr.length; i++) {
			arr[i-1] = arr[i];
		}
	}
	
	public int removeDuplicates2(int[] nums) {
		int i=1, j=1,count=1;
		while(i<nums.length) {
			if(nums[i] == nums[i-1]) {
				if(count > 1) {
					i++;
				} else {
					count++;
					arr[j] = arr[i];
					i++;
					j++;
				}
			} else {
				count = 1;
				arr[j] = arr[i];
				i++;
				j++;
			}
		}
		return j+1;
    }
}