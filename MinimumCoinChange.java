package Day_5;
public class MinimumCoinChange {
    
    public static int coinChange(int[] coins, int amount) {
        // Create a arr array to store the minimum number of coins for each amount
        int[] arr = new int[amount + 1];
        // Initialize all values to a large number, indicating it's not reachable yet
        java.util.Arrays.fill(arr, amount + 1);
        arr[0] = 0; // Base case: 0 coins needed for amount 0
        // Fill the arr array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    arr[i] = Math.min(arr[i], arr[i - coin] + 1);
                }
            }
        }
        // If arr[amount] is still the initial large value, return -1 (not possible)
        return arr[amount] > amount ? -1 : arr[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        
        int result = coinChange(coins, amount);
        System.out.println(result); 
    }
}
