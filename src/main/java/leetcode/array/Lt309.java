class Lt309 {
	public int maxProfit(int[] prices) {
		if(null == prices || prices.length <= 1) {
			return 0;
		}
		
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE, dp_i_0_pre = 0;
		for(int i=0; i<prices.length; i++) {
			int tmp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_i_0_pre  - prices[i]);
			dp_i_0_pre = tmp;
		}
		return dp_i_0;
    }
	
}