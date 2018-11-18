
/*
	key: IF AMOUNT > COIN THEN
			COMBINATION[AMOUNT] += COMBINATION[AMOUNT-COIN]
		this is the iteration relation between numbers in 
		the DP array
*/
public class CoinChange {

	public static void main(String[] args) {
		System.out.println(change(12, new int[]{1,2,5}));
	}

	public static int change(int amount, int[] coins) {
		int[] combinations = new int[amount + 1];

		combinations[0] = 1;

		for (int coin: coins) {
			for (int i = 1; i < combinations.length; i++) {
				if (i > coin)
					combinations[amount] += combinations[i - coin];
					printAmount(combinations);
			}
		}
	}
	// param: int[] arr: DP array
	public static void printAmount(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}