class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        TreeSet<String> t=new TreeSet<String>();
        for(int i=0;i<nums.length;i++)
        {
            int l=0;
            if(nums[i]%p==0)
            {
                l++;
            }
            String str=Integer.toString(nums[i]);
            t.add(str);
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[j]%p==0)
                {
                    l++;
                }
                if(l<=k)
                {
                    str=str+" "+Integer.toString(nums[j]);
                    t.add(str);
                }
                else
                {
                    break;
                }
            }
        }
        
        
        return t.size();
        
    }
}
