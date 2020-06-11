class Lt188 {
    public int maxProfit(int times, int[] prices) {
		if(null == prices || prices.length <= 1) {
			return 0;
		}
		
		if(k > prices.length / 2) {
			return infK(prices);
		}
		
		int[][][] dp = new int[prices.length][3][2];
		for(int i=0; i<prices.length; i++){
			
			for(int k=0; k<=times; k++) {
				
				if(i==0 || k == 0) {
					dp[i][k][0] = 0;
					dp[i][k][1] = -prices[i]; 
					continue;
				}
				
				dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
				dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
				
			}
		}
		return dp[prices.length -1][times][0];
		
	}
	
	public infK(int[] prices) {
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for(int i=0; i<prices.length; i++){
			int tmp = dp_i_0
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
		}
		return dp_i_0;
	}
}