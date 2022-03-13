class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==key)
            {
                l.add(i);
            }
        }
        if(l.size()==nums.length)
        {
            for(int i=0;i<nums.length;i++)
            {
                result.add(i);
            }
        }
        else
        {
            if(l.size()>0)
            {
                for(int i=0;i<l.size();i++)
                {
                    for(int j=0;j<nums.length;j++)
                    {
                        if(Math.abs(l.get(i)-j)<=k)
                        {
                            if(!result.contains(j))
                            {
                                result.add(j);
                            }
                        }
                    }
                }
            }
        }
        
        return result;
        
    }
}
