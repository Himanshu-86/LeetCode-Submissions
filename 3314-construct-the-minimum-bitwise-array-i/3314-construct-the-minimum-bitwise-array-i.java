class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int x = nums.get(i);
            if (x == 2) {
                ans[i] = -1;
                continue;
            }
            int bit = 1;
            while ((x & bit) != 0) {
                bit <<= 1;
            }
            ans[i] = x ^ (bit >> 1);
        }
        return ans;
    }
}