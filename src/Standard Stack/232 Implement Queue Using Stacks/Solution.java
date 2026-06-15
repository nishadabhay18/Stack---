/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();
    public MyQueue() {

    }
    // Method-1 Pop Efficient: push()-> O(n), pop()-> O(1), peek()-> O(1)
    public void push(int x) {
        if(st.size() == 0) st.push(x);
        else{
            while(st.size() > 0) helper.push(st.pop());
            st.push(x);
            while(helper.size() > 0) st.push(helper.pop());
        }
    }

    public int pop() {
        return st.pop();
    }

    public int peek() {
        return st.peek();
    }

    public boolean empty() {
        return (st.size() == 0) ? true: false;
    }

    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();
    public MyQueue() {

    }
    // Method-2 Push Efficient: push()-> O(1), pop()-> O(n), peek()-> O(n)
    public void push(int x) {
        st.push(x);
    }

    public int pop() {
        while(st.size() > 1) helper.push(st.pop());
        int ans = st.pop();
        while(helper.size() > 0) st.push(helper.pop());
        return ans;
    }

    public int peek() {
        while(st.size() > 1) helper.push(st.pop());
        int ans = st.peek();
        while(helper.size() > 0) st.push(helper.pop());
        return ans;
    }

    public boolean empty() {
        return (st.size() == 0) ? true: false;
    }
}