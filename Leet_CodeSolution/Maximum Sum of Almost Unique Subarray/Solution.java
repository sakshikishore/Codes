class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        long sum=0,max=0;
        for(int i=0;i<k;i++)
        {
            sum+=nums.get(i);
            if(!h.containsKey(nums.get(i)))
            {
                h.put(nums.get(i),1);
            }
            else
            {
                h.put(nums.get(i),h.get(nums.get(i))+1);
            }
        }
           if(h.size()>=m)
            {
                if(sum>max)
                {
                    max=sum;
                }
            }
        int p=0;
        for(int i=k;i<nums.size();i++)
        {
            h.put(nums.get(p),h.get(nums.get(p))-1);
            if(h.get(nums.get(p))==0)
            {
                h.remove(nums.get(p));
            }
            sum=sum-nums.get(p);
            sum=sum+nums.get(i);
            if(!h.containsKey(nums.get(i)))
            {
                h.put(nums.get(i),1);
            }
            else
            {
                h.put(nums.get(i),h.get(nums.get(i))+1);
            }
            if(h.size()>=m)
            {
                if(sum>max)
                {
                    max=sum;
                }
            }
           p++;
            
        }
        
        return max;
        
    }
}
