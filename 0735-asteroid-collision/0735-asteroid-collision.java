class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack <Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(asteroids[i] > 0) {
                st.push(asteroids[i]);
            }
            else {
                while(!st.isEmpty() && Math.abs(asteroids[i]) > st.peek() && st.peek() > 0) {
                    st.pop();
                }
                if(!st.isEmpty() && Math.abs(asteroids[i]) == st.peek()) {
                    st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }
        int arr[] = new int[st.size()];
        for(int i = st.size() - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }
        return arr;
    }
}