class CustomStack {

    int top=-1;
    int arr[];
    public CustomStack(int maxSize) {
        arr=new int[maxSize];
        
    }
    
    public void push(int x) {
       if(top<arr.length-1)
       {
        top=top+1;
        arr[top]=x;
       }
    }
    
    public int pop() {
        int result=-1;
       
        if(top>-1)
        {
            result=arr[top];
            top=top-1;
        }
        
        return result;
        
    }
    
    public void increment(int k, int val) {
        if(top<k)
        {
            k=top+1;
        }
        for(int i=0;i<k;i++)
        {
            arr[i]=arr[i]+val;
        }
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
