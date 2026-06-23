class Solution {
    private static final long MOD = 1_000_000_007L;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        if (n == 1) {
            return m;
        }
        if (n == 2) {
            return (int) ((1L * m * (m - 1)) % MOD);
        }
        long[] up = new long[m];
        long[] down = new long[m];
        for (int x = 0; x < m; x++) {
            up[x] = x;
            down[x] = m - 1 - x;
        }
        for (int len = 3; len <= n; len++) {
            long[] prefixDown = new long[m];
            long[] prefixUp = new long[m];
            prefixDown[0] = down[0];
            prefixUp[0] = up[0];
            for (int i = 1; i < m; i++) {
                prefixDown[i] = (prefixDown[i - 1] + down[i]) % MOD;
                prefixUp[i] = (prefixUp[i - 1] + up[i]) % MOD;
            }
            long totalUp = prefixUp[m - 1];
            long[] newUp = new long[m];
            long[] newDown = new long[m];
            for (int x = 0; x < m; x++) {
                if (x > 0) {
                    newUp[x] = prefixDown[x - 1];
                }
                newDown[x] = (totalUp - prefixUp[x] + MOD) % MOD;
            }
            up = newUp;
            down = newDown;
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }
        return (int) ans;
    }
}