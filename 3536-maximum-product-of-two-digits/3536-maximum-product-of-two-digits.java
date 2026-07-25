class Solution {
    public int maxProduct(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        int first = -1, second = -1;
        for (int d = 9; d >= 0; d--) {
            if (freq[d] > 0) {
                first = d;
                freq[d]--;
                break;
            }
        }
        for (int d = 9; d >= 0; d--) {
            if (freq[d] > 0) {
                second = d;
                break;
            }
        }
        return first * second;
    }
}