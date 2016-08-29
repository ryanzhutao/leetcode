
public class MaxProfit {
	
	public int maxProfit(int[] prices) {
        int i = 0;
        int j = 0;
        int lowest = prices[0];
        if(prices.length == 0 || prices.length == 1)
            return 0;
       
        int profit;
        int maxprofit = Integer.MIN_VALUE;
        for (i = 1; i < prices.length ; i++ ) {
            
            
            profit = prices[i] - lowest;
            if(maxprofit < profit) {
                maxprofit = profit;
            }
            if( prices[i] <= lowest) {
                lowest = prices[i];
            }
        }
        return maxprofit >0 ?maxprofit:0;
    }

	public int maxProfit1(int[] prices) {
        int i;
        int lowest = Integer.MAX_VALUE;
        int secondlowest = Integer.MAX_VALUE;
        int len = prices.length;
        int maxprofit = 0;
        int profit = 0;
        for(i = 0; i < len; i++ ) {
            profit = prices[i] - lowest;
            if(profit > 0) {
                maxprofit+= profit;
                lowest = secondlowest;
            }
            if(prices[i] < lowest) {
                secondlowest = lowest;
                lowest = prices[i];
            }
            System.out.println(prices[i] + " " + lowest + " " + secondlowest + " " + profit);
        }
        return maxprofit;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxProfit mp = new MaxProfit();
		int[] prices = {3,2,6,5,0,3};
		System.out.println(mp.maxProfit1(prices));
	}

}
