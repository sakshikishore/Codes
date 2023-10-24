class CountIntervals {
    int result=0;
    PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
    ArrayList<Integer> l1=new ArrayList<Integer>();
    HashMap<Integer,Integer> h;
    int flag=0,p=0,prevLeft=0,prevRight=0;
    public CountIntervals() {
        h=new HashMap<Integer,Integer>();
    }
    
    public void add(int left, int right) {
        p=0;
        if(h.containsKey(left))
        {
            if(h.get(left)<right)
            {
                h.put(left,right);
            }
            p=0;
        }
        else
        {
            pq.add(left);
            h.put(left,right);
            int low=0,high=l1.size()-1,index=0;
                   while(low<=high)
                   {
                       int mid=(low+high)/2;
                       if(l1.get(mid)>left)
                       {
                           high=mid-1;
                           index=mid;
                       }
                       else
                       {
                           low=mid+1;
                           index=mid+1;
                       }
                   }

                    if(index==l1.size())
                    {
                        if(index==0)
                        {
                          if(flag==1)
                          {
                              p=1;
                              prevLeft=left;
                              prevRight=right;
                          }
                        }
                        else
                        {
                            if(h.get(l1.get(index-1))>=left)
                            {
                                p=0;
                            }
                            else
                            {
                                if(flag==1)
                                {
                                    p=1;
                                    prevLeft=left;
                                   prevRight=right;
                                }
                            
                            }
                        }
                    }
                    else
                    {
                        if(index==0)
                        {
                            if(l1.size()==0)
                            {
                                if(flag==1)
                                {
                                    p=1;
                                    prevLeft=left;
                              prevRight=right;
                                }
                            }
                            else if(l1.get(index)>right)
                            {
                                if(flag==1)
                                {
                                    p=1;
                                    prevLeft=left;
                              prevRight=right;
                                }
                            }
                        }
                        else
                        {
                            if(h.get(l1.get(index-1))<left && l1.get(index)>right)
                            {
                                if(flag==1)
                                {
                                    p=1;
                                    prevLeft=left;
                              prevRight=right;
                                }
                            }
                        }
                    }
                   l1.add(index,left);

                  

        }
        flag=0;
    }
    
    public int count() {
        if(flag==0)
        {
            if(p==0)
            {
                result=0;
        if(pq.size()>0)
        {
           int start=pq.poll();
           int end=h.get(start);
           while(pq.size()>0)
           {
               int x=pq.poll();
             
               int y=h.get(x);
               if(x<=end)
               {
                   h.remove(x);
                   l1.remove(new Integer(x));
                   if(y>=end)
                   {
                       end=y;
                   }
               }
               else
               {
                   h.put(start,end);
                   start=x;
                   end=y;
               }
           }
           h.put(start,end);
        }

        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
           int x=entry.getKey();
           int y=entry.getValue();
           pq.add(x);
           result+=y-x+1;

        }
            }
            else
            {
                result+=(prevRight-prevLeft+1);        
            }
          flag=1;
        }

        return result;

    }
}
