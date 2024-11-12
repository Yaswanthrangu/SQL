class Pair {
    int first;
    int second;
    public Pair(int f, int s) {
        first = f;
        second = s;
    }
}
class MinStack {

    Stack <Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()) {
            st.add(new Pair(val, val));
        }
        else {
            st.add(new Pair(val, Math.min(val, st.peek().second)));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().first;
    }
    
    public int getMin() {
        return st.peek().second;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */