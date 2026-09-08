class Solution {
    public int countCommas(int n) {
        int ans = 0;

        for (long divisor = 1000; divisor <= n; divisor *= 1000) {
            ans += n - divisor + 1;
            if (divisor > n / 1000) {
                break;
            }
        }
        return ans;
    }
}