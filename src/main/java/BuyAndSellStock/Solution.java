package BuyAndSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(int price: prices){
            if(price < buy){
                buy = price;
                sell = price;
            }else{
                if(price >= sell){
                    sell = price;
                }
            }

            maxProfit = Math.max(maxProfit, sell-buy);
        }

        return maxProfit;
    }
}
