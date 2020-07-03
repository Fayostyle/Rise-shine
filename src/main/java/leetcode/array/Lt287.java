class Solution {
    public int findDuplicate(int[] nums) {
		Set<Integer> s = new HashSet<>();
		for(int n : nums) {
			if(s.contains(n)) {
				return n;
			}
			s.add(n);
		}
		
		return 0;
    }
}