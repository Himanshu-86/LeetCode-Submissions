class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int left = 0;
        long ans = 0;
        
        for (int right = 0; right < nums.length; right++) {
            
            // Maintain decreasing maxDeque
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            
            // Maintain increasing minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            
            // Shrink window if invalid
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                left++;
                
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }
            
            ans += (right - left + 1);
        }
        
        return ans;
    }
}