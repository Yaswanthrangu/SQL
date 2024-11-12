class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmall = nextSmaller(heights);
        int[] prevSmall = prevSmaller(heights);
        
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nextSmall[i] - prevSmall[i] - 1; 
            maxArea = Math.max(maxArea, height * width);
        }
        
        return maxArea;
    }

    private int[] nextSmaller(int[] heights) {
        int n = heights.length;
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        return next;
    }

    private int[] prevSmaller(int[] heights) {
        int n = heights.length;
        int[] prev = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        return prev;
    }
}