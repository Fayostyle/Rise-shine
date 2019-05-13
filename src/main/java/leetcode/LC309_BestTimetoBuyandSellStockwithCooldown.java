package leetcode;

public class LC309_BestTimetoBuyandSellStockwithCooldown {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int buy = 0, preBuy = 0, sell = 0, preSell = 0;
        for(int i=0; i<prices.length; i++) {
            buy = Math.max(preSell - prices[i], preBuy);
        }
return 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,0,2};
        maxProfit(arr);
    }
}
