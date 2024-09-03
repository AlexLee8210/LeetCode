class MyStack {

    Queue<Integer> q1;
    // Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        // q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        Queue<Integer> q2 = new LinkedList<>();
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int ret = q1.poll();
        q1 = q2;

        return ret;
    }
    
    public int top() {
        Queue<Integer> q2 = new LinkedList<>();
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int ret = q1.poll();
        q2.offer(ret);
        q1 = q2;

        return ret;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */