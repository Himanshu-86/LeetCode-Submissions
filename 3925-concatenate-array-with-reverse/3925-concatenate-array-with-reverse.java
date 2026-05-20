class Solution {
    public int[] concatWithReverse(int[] nums) {

        int n = nums.length;
        int[] result = new int[2 * n];

        for (int i = 0; i < n; i++) {
            result[i] = nums[i];
        }
        int index = n;
        for (int i = n - 1; i >= 0; i--) {
            result[index] = nums[i];
            index++;
        }
        return result;
    }
}