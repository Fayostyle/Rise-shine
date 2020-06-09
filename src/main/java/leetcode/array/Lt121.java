class Lt121 {
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		
		int profit = 0;
		for(int i=1; i<prices.length; i++) {
			if(prices[i] < min) {
				min = prices[i];
			} else if(prices[i] - min > profit) {
				profit = prices[i] - min;
			}
		}
		return profit;
    }
	
	
	public int maxProfit2(int[] prices) {
		if(null == prices || prices.length <= 1) return 0;
		int[][] dp = new int[prices.length][2];
		for(int i=0; i<prices.length; i++) {
			if(i == 0) {
				dp[i][0] = 0;
				dp[i][1] = -prices[i];
			} else {
				dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
				dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
			}
		}
		return dp[prices.length - 1][0];
	}
	
	public int maxProfit3(int[] prices) {
		if(null == prices || prices.length <= 1) return 0;
		int dp_i_0 = 0, dp_i_1 = -prices[0];
		for(int i=0; i<prices.length; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}
		
		return dp_i_0;
		
		
	}	
	
}