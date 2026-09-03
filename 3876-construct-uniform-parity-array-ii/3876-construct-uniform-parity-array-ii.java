class Solution {
    public boolean uniformArray(int[] nums1) {
        return canMake(nums1, 0) || canMake(nums1, 1);
    }

    private boolean canMake(int[] nums, int targetParity) {
        int[] arr = nums.clone();
        Arrays.sort(arr);

        boolean seenOdd = false;
        boolean seenEven = false;

        for (int x : arr) {
            int parity = x % 2;

            if (parity == targetParity) {
                if (parity == 0)
                    seenEven = true;
                else
                    seenOdd = true;
                continue;
            }

            if (targetParity == 1) {
                if (!seenOdd)
                    return false;
            } else {
                if (!seenOdd)
                    return false;
            }

            if (parity == 0)
                seenEven = true;
            else
                seenOdd = true;
        }

        return true;
    }
}