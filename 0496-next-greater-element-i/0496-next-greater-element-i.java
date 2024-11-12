class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2 = nums2.length;
        int n1 = nums1.length;
        int ans[] = nextGreater(nums2);
        HashMap <Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n2; i++) {
            mp.put(nums2[i], ans[i]);
        }
        int answer[] = new int[n1];
        for(int i = 0; i < n1; i++) {
            int ele = nums1[i];
            answer[i] = mp.get(ele);
        }
        return answer;
    }
    public static int[] nextGreater(int[] nums2) {
        int n2 =nums2.length;
        Stack <Integer> st = new Stack<>();
        int ans[] = new int[n2];
        for(int i = n2-1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = st.peek();
            }
            st.push(nums2[i]);
        }
        return ans;
    }
}