class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int start=0,max=0;
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(nums[i],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(nums[i]);
                if(l.size()+1>k)
                {
                    if(i-start>max)
                    {
                        max=i-start;
                    }
                    int index=l.get(0);
                    l.remove(0);
                    l.add(i);
                    h.put(nums[i],l);
                    for(int j=start;j<index;j++)
                    {
                         ArrayList<Integer> list=h.get(nums[j]);
                         list.remove(0);
                        if(list.size()==0)
                        {
                            h.remove(nums[j]);
                        }
                        else
                        {
                         h.put(nums[j],list);
                        }
                    }
                    start=index+1;
                }
                else
                {
                     l.add(i);
                     h.put(nums[i],l);
                }
            }
        }
        if(nums.length-start>max)
        {
            max=nums.length-start;
        }
        
        return max;
    }
}
