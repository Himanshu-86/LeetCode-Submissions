class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        int windows = nums.length - k + 1;

        for (int i = 0; i < windows; i++) {
            Set<Integer> seen = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                seen.add(nums[j]);
            }

            for (int x : seen) {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }

        int answer = -1;

        for (int x : count.keySet()) {
            if (count.get(x) == 1) {
                answer = Math.max(answer, x);
            }
        }

        return answer;
    }
}