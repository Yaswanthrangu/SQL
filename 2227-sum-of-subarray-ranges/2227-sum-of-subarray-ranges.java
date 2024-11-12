class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        
        long[] lesserLeft = new long[n];
        long[] lesserRight = new long[n];
        long[] greaterLeft = new long[n];
        long[] greaterRight = new long[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            long count = 1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                count += lesserLeft[stack.pop()];
            }
            lesserLeft[i] = count;
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            long count = 1;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                count += lesserRight[stack.pop()];
            }
            lesserRight[i] = count;
            stack.push(i);
        }

        stack.clear();
        for (int i = 0; i < n; i++) {
            long count = 1;
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                count += greaterLeft[stack.pop()];
            }
            greaterLeft[i] = count;
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            long count = 1;
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                count += greaterRight[stack.pop()];
            }
            greaterRight[i] = count;
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ((lesserLeft[i] * lesserRight[i]) - (greaterLeft[i] * greaterRight[i])) * nums[i];
        }
        
        return ans;
    }
}