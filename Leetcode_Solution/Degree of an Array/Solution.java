class Solution {
    public int findShortestSubArray(int[] nums) {
        int max=1;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
            }
            else
            {
                int p=h.get(nums[i])+1;
                h.put(nums[i],p);
                if(max<p)
                {
                    max=p;
                   
                }
            }
        }
        
        ArrayList<Integer> l=new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(h.get(nums[i])==max && !l.contains(nums[i]))
            {
                
                l.add(nums[i]);
            }
        }
     int min=Integer.MAX_VALUE;
        for(int j=0;j<l.size();j++)
        {
                     
            int start=-1,end=-1;       
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]==l.get(j))
                {
                    start=i;
                    break;
                }
            }

            for(int i=nums.length-1;i>=0;i--)
            {
                if(nums[i]==l.get(j))
                {
                    end=i;
                    break;
                }
            }
            if(end-start+1<min)
            {
                min=end-start+1;
            }
        }
        return min;
    }
}
