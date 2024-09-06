package leetcode;

public class _322_零钱兑换 {
    static int n = Integer.MAX_VALUE;

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        if (n == Integer.MAX_VALUE) {
            for (int coin : coins) {
                n = Math.min(n, coin);
            }

        }
        if (amount < n) return -1;
        for (int coin : coins) {
            if (coin == amount) {
                return 1;
            }

        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            min = Math.min(min, coinChange(coins, amount - coin));
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min + 1;


    }

    public static void main(String[] args) {
        int i = coinChange(new int[]{2}, 1);
        System.out.println(i);
    }

}
