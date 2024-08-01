class Solution {
    public int[] avoidFlood(int[] rains) {
        int result[]=new int[rains.length];
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<rains.length;i++)
        {
            if(!h.containsKey(rains[i]))
            {
                if(rains[i]!=0)
                {
                ArrayList<Integer> list= new ArrayList<Integer>();
                list.add(i);
                h.put(rains[i],list);
                }
            }
            else
            {
                 ArrayList<Integer> list=h.get(rains[i]);
                list.add(i);
                h.put(rains[i],list);
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<rains.length;i++)
        {
             if(rains[i]==0)
             {
                 if(pq.size()==0)
                 {
                    result[i]=1;
                 }
                 else
                 {
                    int x=pq.poll();
                    result[i]=rains[x];
                     map.remove(rains[x]);
                 }
             }
             else
             {
                if(map.containsKey(rains[i]))
                {
                    result=new int[0];
                    return result;
                }
                else
                {
                    result[i]=-1;
                    ArrayList<Integer> l=h.get(rains[i]);
                    int low=0,high=l.size()-1,index=0;
                    while(low<=high)
                    {
                        int mid=(low+high)/2;
                        if(l.get(mid)==i)
                        {
                            index=mid;
                            break;
                        }
                        else if(l.get(mid)>i)
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
                        if(index<l.size()-1)
                        {
                          
                              map.put(rains[i],1);
                              pq.add(l.get(index+1));
                        }
                    
                }
             }
        }

        return result;

    }
}
