public class Lt189{
		public void ratate(int[] nums, int k) {
			int count=0, start=0;
			while(count<nums.length) {
				int pre = nums[start];
				int i = start;
				do{
					int aimIndex = (k + i) % nums.length;
					int tmp = nums[aimIndex];
					nums[aimIndex] = pre;
					count++;
					pre = tmp;
					i = aimIndex;
				} while(start != i);
				start++;
			}
		}
}