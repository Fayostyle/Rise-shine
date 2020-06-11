class Lt42 {
	public int trap1(int[] height) {
		if(null == height) return 0;
		
		int ans = 0;
		for(int i=1; i < height.length - 1; i++) {
			int left = height[i], right = height[i];
			for(int l = i-1; l>=0; l--) {
				left = Math.max(left, height[l]);
			}
			for(int r = i+1; r<height.length; r++) {
				r = Math.max(right, height[r]);
			}
			
			ans += Math.min(left, right) - height[i];
		}
		return res;
    }
}