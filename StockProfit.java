/*Given an array of stock prices, find the maximum profit that can be earned by doing a single transaction of buy and sell in the given period of time.

e.g:
100, 80, 120, 130, 70, 60, 100, 125

Profit: 65 */
import java.util.Arrays;

public class StockProfit{
	public static void main(String [] args){
		int [] prices = {100, 80, 120, 130, 70, 60, 100, 125};

		int [] result = findBuyAndSell(prices);

		System.out.println("[ Buying, Selling, Profit ] : " +  Arrays.toString(result));
	}

	private static int[] findBuyAndSell(int [] prices){
		int [] res = new int[3];
		res[0] = Integer.MAX_VALUE; // initial buying price
		res[1] = 0; //initial selling price
		res[2] = 0; // iniital profit

		int profit = 0;

		for(int i = 0; i < prices.length; i++){
			if(res[0] > prices[i]){
				res[0] = prices[i];
			}

			if(profit < prices[i] - res[0]){
				profit = prices[i] - res[0];
				res[1] = prices[i];
			}
			res[2] = profit;
			
		}

		return res;
	}
}
