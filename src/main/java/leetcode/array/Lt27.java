public class Lt27 {
	    public int removeElement(int[] nums, int val) {
			if(nums == null || nums.length == 0) {
				return 0;
			}
			int i=0,j=0;
			for(;i < nums.length; i++) {
				if(nums[i] != val){
					nums[j++] = nums[i];
				}
			}
			return j;
    }
	
	
	//方法2
	public int removeElement2(int[] nums, int val) {
			if(nums == null || nums.length == 0) {
				return 0;
			}
			//等于val， 就拿队尾的替换掉，直到两个指针相遇，说明全部遍历完了
			int i=0, n=nums.length;
			while(i < n) {
				if(nums[i] == val) {
					nums[i] = nums[n-1];
					n--;
				} else {
					i++;
				}
			}
			return n;
    }
}