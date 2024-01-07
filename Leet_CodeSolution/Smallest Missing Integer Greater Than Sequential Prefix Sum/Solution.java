class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        int result=0;
        int flag=0;
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            hset.add(nums[i]);
        }
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1]+1)
            {
                sum+=nums[i];

            }
            else
            {
                flag=1;
                    while(hset.contains(sum))
                    {
                        sum++;
                    }
                    
                    result=sum;
                break;
                   
            }
        }
    
        
        if(flag==0)
                {
                    while(hset.contains(sum))
                    {
                        sum++;
                    }
               result=sum;
                    
             }
            
            return result;
    }
}
