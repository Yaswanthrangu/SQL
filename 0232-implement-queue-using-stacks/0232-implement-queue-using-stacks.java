class MyQueue {

    Stack <Integer> s1;
    Stack <Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        int sz1 = s1.size();
        for(int i = 0; i < sz1; i++) {
            s2.add(s1.pop());
        }
        s1.add(x);
        int sz2 = s2.size();
        for(int i = 0; i < sz2; i++) {
            s1.add(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */