class Solution {
    private long combCap(int n, int r, long cap) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r);

        long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - r + i) / i;
            if (ans >= cap) return cap;
        }
        return ans;
    }

    private long countWays(int[] cnt, long cap) {
        int rem = 0;
        for (int x : cnt) rem += x;

        long ways = 1;
        int left = rem;

        for (int x : cnt) {
            if (x == 0) continue;

            long c = combCap(left, x, cap);

            if (ways > cap / c) return cap;
            ways *= c;

            if (ways >= cap) return cap;
            left -= x;
        }
        return ways;
    }

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int[] half = new int[26];
        StringBuilder mid = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if ((freq[i] & 1) == 1) {
                mid.append((char) ('a' + i));
            }
        }

        if (countWays(half, k) < k) {
            return "";
        }

        int halfLen = s.length() / 2;
        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;

                long ways = countWays(half, k);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                }

                k -= ways;
                half[c]++;
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        return left.toString() + mid.toString() + right.toString();
    }
}