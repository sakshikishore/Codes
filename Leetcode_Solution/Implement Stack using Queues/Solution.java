class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new  LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result=0;
       while(q1.size()!=1)
       {
            q2.add(q1.poll());
        }
        
        result=q1.poll();
        while(q2.size()!=0)
        {
        q1.add(q2.poll());
        }
        
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        int res=0;
        while(q1.size()!=1)
        {
            q2.add(q1.poll());
        }
        
        res=q1.peek();
        q2.add(q1.poll());
        
        while(q2.size()!=0)
        {
        
            q1.add(q2.poll());
        }
        
        return res;
        
        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        
        boolean result=false;
        if(q1.size()==0)
        {
            result=true;
        }
        
        return result;
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
