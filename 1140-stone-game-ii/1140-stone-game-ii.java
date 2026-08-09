class Solution {
    private int[][] memo;
    private int[] suffix;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        memo = new int[n][n + 1];
        return dp(0, 1);
    }

    private int dp(int i, int M) {
        // Can take all remaining piles
        if (i + 2 * M >= n) {
            return suffix[i];
        }
        if (memo[i][M] != 0) {
            return memo[i][M];
        }
        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int nextM = Math.max(M, X);
            int current = suffix[i] - dp(i + X, nextM);
            best = Math.max(best, current);
        }
        memo[i][M] = best;
        return best;
    }
}