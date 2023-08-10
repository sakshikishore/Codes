class DinnerPlates {
  HashMap<Integer,Stack<Integer>> h=new HashMap<Integer,Stack<Integer>>();
  PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
  ArrayList<Integer> l=new ArrayList<Integer>();
  int i=0;
  int cap=0;
    public DinnerPlates(int capacity) {
        cap=capacity;
        pq.add(i);
    }
    
    public void push(int val) {
        int x=pq.peek();
        
        if(h.containsKey(x))
        {
              Stack<Integer> s= h.get(x);
              if(s.size()==0)
              {
                 if(l.size()==0)
                 {
                     l.add(x);
                 }
                 else if(l.size()==1)
                 {
                     if(l.get(0)>x)
                     {
                         l.add(0,x);
                     }
                     else
                     {
                         l.add(x);
                     }
                 }
                 else
                 {
                     int low=0,high=l.size()-1,index=0;
                     while(low<=high)
                     {
                         int mid=(low+high)/2;
                         if(l.get(mid)>x)
                         {
                             index=mid;
                             high=mid-1;
                         }
                         else
                         {
                             index=mid+1;
                             low=mid+1;
                             
                         }
                     }
                     l.add(index,x);
                 }
              }
              s.push(val);
              h.put(x,s);
              if(s.size()==cap)
              {
                  pq.poll();
                  if(pq.size()==0)
                  {
                    i++;
                    pq.add(i);
                  }
              }
        }
        else
        {
              Stack<Integer> s= new Stack<Integer>();
              s.push(val);
              h.put(i,s);
              l.add(i);
              if(s.size()==cap)
              {
                  pq.poll();
                  if(pq.size()==0)
                  {
                    i++;
                    pq.add(i);
                  }
              }
        }
    }
    
    public int pop() {
       if(l.size()==0)
       {
           return -1;
       }
       else
       {
           int x=l.get(l.size()-1);
           Stack<Integer> stck=h.get(x);
           if(stck.size()==cap)
           {
                pq.add(x);
           }
           int val = stck.pop();
           if(stck.size()==0)
           {
               int t=l.size()-1;
                l.remove(t);
           }
           h.put(x,stck);
           return val;
       }
        
    }
    
    public int popAtStack(int index) {
        if(h.size()<=index || index==-1)
        {
            return -1;
        }
        else
        {
            Stack<Integer> s= h.get(index);
            if(s.empty())
            {
                return -1;
            }
            if(s.size()==cap)
            {
                pq.add(index);
            }
             int x= s.pop();
               if(s.size()>1)
                {
                     int low=0,high=l.size()-1,idx=0;
                     while(low<=high)
                     {
                         int mid=(low+high)/2;
                         if(l.get(mid)==index)
                         {
                             idx=-1;
                             break;
                         }
                         if(l.get(mid)>index)
                         {
                             idx=mid;
                             high=mid-1;
                         }
                         else
                         {
                             idx=mid+1;
                             low=mid+1;
                             
                         }
                     }
                     if(idx!=-1)
                     {
                     l.add(idx,index);
                     }
                 }

             else if(s.size()==0)
             {
                     int low=0,high=l.size()-1;
                     while(low<=high)
                     {
                         int mid=(low+high)/2;
                         if(l.get(mid)==index)
                         {
                             l.remove(mid);
                             break;
                         }
                         else if(l.get(mid)>index)
                         {
                             high=mid-1;
                         }
                         else
                         {
                             low=mid+1;      
                         }
                     }
             }
             h.put(index,s); 
            return x;
        }
    }
}
