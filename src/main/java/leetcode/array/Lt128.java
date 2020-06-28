class Solution {
    public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int n : nums) {
			set.add(n);
		}
		
		int longestSeq = 1;
		
		for(int n : nums) {
			int curSeq = 1;
			int curNum = n;
			while(set.contains(curNum + 1)) {
				curSeq++;
				curNum++;
			}
			longestSeq = Math.max(longestSeq, curSeq);
		}
		return longestSeq;
   }
}