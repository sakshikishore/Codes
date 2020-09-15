class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> st;
    ArrayList<Integer> l=new ArrayList<Integer>();
    public MinStack() {
        
        st=new Stack<Integer>();
    }
    
    public void push(int x) {
        st.push(x);
        l.add(x);
        
    }
    
    public void pop() {
        int p=st.pop();
        l.remove(new Integer(p));
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        Collections.sort(l);
        return l.get(0);
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
