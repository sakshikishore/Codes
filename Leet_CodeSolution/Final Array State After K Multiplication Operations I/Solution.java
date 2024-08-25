class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if(multiplier==1)
        {
             return nums;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            if(!h.containsKey(nums[i]))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(i);
                h.put(nums[i],list);
            }
            else
            {
                ArrayList<Integer> list=h.get(nums[i]);
                list.add(i);
                h.put(nums[i],list);
            }
        }
        int i=0;
        while(i<k)
        {
            int x=pq.poll();
            ArrayList<Integer> l=h.get(x);
            int index=l.remove(0);
            if(l.size()==0)
            {
                h.remove(x);
            }

            x=x*multiplier;
            if(h.containsKey(x))
            {
                ArrayList<Integer> list=h.get(x);
                int low=0,high=list.size()-1;
                while(low<=high)
                {
                    int mid=(low+high)/2;
                    if(list.get(mid)>index)
                    {
                        high=mid-1;
                    }
                    else
                    {
                        low=mid+1;
                    }
                }
                list.add(low,index);
                h.put(x,list);

            }
            else
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(index);
                h.put(x,list);
            }

            pq.add(x);
            i++;

        }

        for(Map.Entry<Integer,ArrayList<Integer>> entry:h.entrySet())
        {
            ArrayList<Integer> list=entry.getValue();
            for(i=0;i<list.size();i++)
            {
                nums[list.get(i)]=entry.getKey();
            }
        }

        return nums;
        
        
    }
}
