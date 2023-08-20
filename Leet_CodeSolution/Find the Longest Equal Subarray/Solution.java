class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.size();i++)
        {
            if(!h.containsKey(nums.get(i)))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                list.add(nums.get(i));
                l.add(i);
                h.put(nums.get(i),l);
            }
            else
            {
                ArrayList<Integer> l=h.get(nums.get(i));
                l.add(i);
                h.put(nums.get(i),l);
            }
        }
        for(int i=0;i<list.size();i++)
        {
            int len=h.get(list.get(i)).size();
            if(!map.containsKey(len))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(list.get(i));
                map.put(len,l);
                pq.add(len);
            }
            else
            {
                ArrayList<Integer> l=map.get(len);
                l.add(list.get(i));
                map.put(len,l);
                pq.add(len);
            }
        }
        int max=0;
        if(k>=nums.size()-pq.peek())
        {
            return pq.peek();
        }
        while(pq.size()>0)
        {
            int x=pq.poll();
            if(x<=max)
            {
                break;
            }
            ArrayList<Integer> l=map.get(x);
            for(int i=0;i<l.size();i++)
            {
                ArrayList<Integer> al=h.get(l.get(i));
                int start=0;
                int p=0;
                ArrayList<Integer> t=new ArrayList<Integer>();
                for(int j=1;j<al.size();j++)
                {
                    int y=(al.get(j)-al.get(j-1))-1;
                    if(y+p>k)
                    {
                        int flag=0;
                        if(j-start>max)
                        {
                            max=j-start;
                            if(max==x)
                            {
                                break;
                            }
                        }
                        while(t.size()!=0)
                        {
                            p=p-t.get(0);
                            start++;
                            t.remove(0);
                            if(y+p<=k)
                            {
                                p=y+p;
                                t.add(y);
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0)
                        {
                            p=0;
                            start=j;
                        }
                    }
                    else
                    {
                        p=p+y;
                        t.add(y);
                    }
                    
                }
                if(al.size()-start>max)
                {
                    max=al.size()-start;
                    if(max==x)
                    {
                        break;
                    }
                }
                if(max==x)
                {
                    break;
                }
            }
            if(max==x)
            {
                break;
            }
        }
        
        return max;
        
        
    }
}
