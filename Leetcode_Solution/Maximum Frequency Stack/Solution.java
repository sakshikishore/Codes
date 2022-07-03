class FreqStack {
   HashMap<Integer,Integer> h;
    Stack<Integer> stck1=new Stack<Integer>();
    public FreqStack() {
        h=new LinkedHashMap<Integer,Integer>();
    }
    
    public void push(int val) {
        stck1.push(val);
        if(!h.containsKey(val))
        {
            h.put(val,1);
        }
        else
        {
            h.put(val,h.get(val)+1);
        }
    }
    
    public int pop() {
     int maxVal=-1;
        int ans=-1;
      for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
           int val=entry.getValue();
           if(val>maxVal)
           {
               maxVal=val;
           }
            
        }
        Stack<Integer> stck2=new Stack<Integer>();
        while(stck1.size()>0)
        {
            int x=stck1.peek();
            if(h.get(x)==maxVal)
            {
                ans=x;
                stck1.pop();
                h.put(x,h.get(x)-1);
                if(h.get(x)==0)
                {
                    h.remove(x);
                }
                while(!stck2.empty())
                {
                    stck1.push(stck2.pop());
                }
                break;
            }
            else
            {
                stck2.push(stck1.pop());
            }
        }
        
        return ans;
    }
}
