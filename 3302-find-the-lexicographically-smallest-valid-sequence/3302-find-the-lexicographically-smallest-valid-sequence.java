class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (m > n) {
            return new int[0];
        }
        int[] suf = new int[m + 1];
        Arrays.fill(suf, -1);
        suf[m] = n;
        int p = n - 1;

        for (int j = m - 1; j >= 0; j--) {
            while (p >= 0 && word1.charAt(p) != word2.charAt(j)) {
                p--;
            }
            if (p < 0) {
                break;
            }
            suf[j] = p;
            p--;
        }

        int[] ans = new int[m];
        int prev = -1;
        boolean usedChange = false;
        for (int j = 0; j < m; j++) {
            boolean found = false;

            for (int i = prev + 1; i < n; i++) {

                if (word1.charAt(i) == word2.charAt(j)) {
                    ans[j] = i;
                    prev = i;
                    found = true;
                    break;
                }
                if (!usedChange && suf[j + 1] > i) {
                    ans[j] = i;
                    prev = i;
                    usedChange = true;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return new int[0];
            }
        }
        return ans;
    }
}