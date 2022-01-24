class Solution {
    public List<Integer> findLonely(int[] nums) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                if(i+1==nums.length)
                {
                    l.add(nums[i]);
                }
                
                else if(i+1<nums.length && (nums[i+1]!=nums[i]+1) && nums[i+1]!=nums[i])
                   {
                       l.add(nums[i]);
                   }
            }
            else if(i==nums.length-1)
                   {
                       if(i-1>=0 && nums[i-1]!=nums[i]-1 && nums[i-1]!=nums[i])
                       {
                           l.add(nums[i]);
                       }
                   }
                   else
                   {
                       if(nums[i-1]!=nums[i] && nums[i+1]!=nums[i] && nums[i-1]+1!=nums[i] && nums[i+1]-1 != nums[i])
                       {
                            l.add(nums[i]);
                       }
                       
                   }
        }
        
        return l;
    }
}
