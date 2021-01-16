class MyCircularDeque {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    ArrayList<Integer> l;
    int p=-1,q;
    public MyCircularDeque(int k) {
        l=new ArrayList<Integer>();
        q=k;
        
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
     boolean result=false;
        if(p<q-1)
        {
            p++;
            l.add(0,value);
            result=true;
        }
        return result;

    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
       boolean result=false;
        if(p<q-1)
        {
            p++;
            l.add(value);
            result=true;
        }
        return result;
        
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        boolean result=false;
        if(p>=0)
        {
            result=true;
            l.remove(0);
            p--;
        }
        
        return result;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        boolean result=false;
        if(p>=0)
        {
            result=true;
            l.remove(p);
            p--;
        }
        return result;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        int result=-1;
        if(p>=0)
        {
            result=l.get(0);
        }
        return result;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        int result=-1;
        if(p>=0)
        {
            result=l.get(p);
        }
        return result;
        
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        boolean result=false;
        if(p<0)
        {
            result=true;
        }
        
        return result;
        
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        boolean result=false;
        if(p>=q-1)
        {
            result=true;
        }
        return result;
        
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
