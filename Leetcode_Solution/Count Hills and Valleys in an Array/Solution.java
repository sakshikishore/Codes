class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=1;i<nums.length-1;i++)
        {
            if(nums[i-1]!=nums[i] && nums[i+1]!=nums[i])
            {
                if(nums[i-1]<nums[i] && nums[i+1]<nums[i])
                {
                    l.add(i);
                    count++;
                }
                if(nums[i-1]>nums[i] && nums[i+1]>nums[i])
                {
                    l.add(i);
                    count++;
                }
            }
            else
            {
                if(nums[i-1]!=nums[i])
                {
                int j=i-1,k=i+1;
                if(nums[i-1]==nums[i])
                {
                    j=i-2;
                    while(j>=0 && nums[j]==nums[i])
                    {
                        j--;
                    }
                    if(j<0)
                    {
                      continue;
                    }
                }
                if(nums[i+1]==nums[i])
                {
                    k=i+2;
                    while(k<nums.length && nums[k]==nums[i])
                    {
                        k++;
                    }
                    if(k==nums.length)
                    {
                        continue;
                    }
                }
                
                if(nums[j]<nums[i] && nums[k]<nums[i])
                {
                    l.add(i);
                    count++;
                }
                if(nums[j]>nums[i] && nums[k]>nums[i])
                {
                    l.add(i);
                    count++;
                }
            }
            }
        }
        
        return count;
    }
}
