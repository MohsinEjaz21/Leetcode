package com.luv2code.coin;

public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
		if (amount < 1) {
			return 0;			
		}
		
		int[] dp = new int[amount + 1];
		int sum = 0;

		while (++sum <= amount) {
			int min = -1;
			for (int coin : coins) {
				if (sum >= coin && dp[sum - coin] != -1) {
					int temp = dp[sum - coin] + 1;
					if(min < 0 || temp < min) {
						min = temp;
					}
				}
			}
			dp[sum] = min;
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;

//		int[] coins = {186,419,83,408};
//		int amount = 6249;

		System.out.println(coinChange(coins, amount));
	}

}
