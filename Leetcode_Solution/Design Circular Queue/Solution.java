class MyCircularQueue {
    int arr[];
    int top=-1;

    public MyCircularQueue(int k) {
        arr=new int[k];
        
    }
    
    public boolean enQueue(int value) {
        boolean result=false;
        if(top<arr.length-1)
        {
            top++;
            arr[top]=value;   
            result=true;
        }
        
        return result;        
    }
    
    public boolean deQueue() {
        boolean result=false;
        if(top>-1)
        {
            for(int j=0;j<top;j++)
            {
                arr[j]=arr[j+1];
            }
            top--;
            result=true;
        }    
        
        return result;
    }
    
    public int Front() {
        int result=-1;
        if(top>-1)
        {
            result=arr[0];
        }
        return result;
        
    }
    
    public int Rear() {
        int result=-1;
        if(top>-1)
        {
            result=arr[top];
        }
        return result;
        
    }
    
    public boolean isEmpty() {
        boolean result=false;
        if(top==-1)
        {
            result=true;
        }
        
        return result;
        
    }
    
    public boolean isFull() {
         boolean result=false;
        if(top==arr.length-1)
        {
            result=true;
        }
        
        return result;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
