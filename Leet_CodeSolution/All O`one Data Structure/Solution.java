class AllOne {
    ArrayList<Integer> l=new ArrayList<Integer>();
    HashMap<String,Integer> h;
    HashMap<Integer,HashMap<String,Integer>> map=new HashMap<Integer,HashMap<String,Integer>>();
    public AllOne() {
        h=new HashMap<String,Integer>();
    }
    
    public void inc(String key) {
        if(!h.containsKey(key))
        {
            h.put(key,1);
            if(!map.containsKey(1))
            {
                HashMap<String,Integer> h1=new HashMap<String,Integer>();
                h1.put(key,1);
                map.put(1,h1);
                l.add(0,1);
            }
            else
            {
                HashMap<String,Integer> h1=map.get(1);
                h1.put(key,1);
                map.put(1,h1);

            }
        }
        else
        {
            int x=h.get(key);
             if(map.get(x).size()==1)
             {
                 map.remove(x);
                 if(l.size()==1)
                 {
                     l.remove(0);
                 }
                 else
                 {
                   int low=0,high=l.size()-1;
                   while(low<=high)
                   {
                       int mid=(low+high)/2;
                       if(l.get(mid)==x)
                       {
                           l.remove(mid);
                           break;
                       }
                       else if(l.get(mid)>x)
                       {
                          high=mid-1;
                       }
                       else
                       {
                           low=mid+1;
                       }
                   }
                 }
             }
             else
             {
                 HashMap<String,Integer> temp=map.get(x);
                 temp.remove(key);
                 map.put(x,temp);
             }
             h.put(key,x+1);
             if(!map.containsKey(x+1))
             {
                HashMap<String,Integer> h1=new HashMap<String,Integer>();
                h1.put(key,x+1);
                map.put(x+1,h1);
                int index=0,low=0,high=l.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>x+1)
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
                l.add(index,x+1);
             }
             else
             {
                 HashMap<String,Integer> h1=map.get(x+1);
                h1.put(key,x+1);
                map.put(x+1,h1);
             }
            
        }
    }
    
    public void dec(String key) {
        if(h.get(key)==1)
        {
            if(map.get(1).size()==1)
            {
                map.remove(1);
                l.remove(0);
            }
            else
            {
                  HashMap<String,Integer> temp=map.get(1);
                 temp.remove(key);
                map.put(1,temp);
            }
            h.remove(key);
        }
        else
        {
            int x=h.get(key);
            if(map.get(x).size()==1)
            {
                map.remove(x);
                int low=0,high=l.size()-1;
                   while(low<=high)
                   {
                       int mid=(low+high)/2;
                       if(l.get(mid)==x)
                       {
                           l.remove(mid);
                           break;
                       }
                       else if(l.get(mid)>x)
                       {
                          high=mid-1;
                       }
                       else
                       {
                           low=mid+1;
                       }
                   }

            }
            else
            {
                HashMap<String,Integer> temp=map.get(x);
                 temp.remove(key);
                 map.put(x,temp);
            }
            if(map.containsKey(x-1))
            {
                HashMap<String,Integer> h1=map.get(x-1);
                h1.put(key,x-1);
                map.put(x-1,h1);
            }
            else
            {
                HashMap<String,Integer> h1=new HashMap<String,Integer>();
                h1.put(key,x-1);
                map.put(x-1,h1);
                int index=0,low=0,high=l.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(l.get(mid)>x-1)
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
                l.add(index,x-1);
            }
            h.put(key,x-1);
        }
    }
    
    public String getMaxKey() {
        String maxKey="";
        if(l.size()>0)
        {
            int x=l.get(l.size()-1);
            HashMap<String,Integer> temp=map.get(x);
            for(Map.Entry<String,Integer> entry:temp.entrySet())
            {
                maxKey=entry.getKey();
                break;
            }
        }
        
        return maxKey;
    }
    
    public String getMinKey() {
        String minKey="";
        if(l.size()>0)
        {
            int x=l.get(0);
            HashMap<String,Integer> temp=map.get(x);
            for(Map.Entry<String,Integer> entry:temp.entrySet())
            {
                minKey=entry.getKey();
                break;
            }
        }
        
        
        return minKey;
    }
}
