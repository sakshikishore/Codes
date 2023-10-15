class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int result[]={-1,-1};
        HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h1.containsKey(nums[i]))
            {
                h1.put(nums[i],i);
            }
        }
         HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
         for(int i=0;i<nums.length;i++)
         {
             h2.put(nums[i],i);
         }
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            int flag=0;
            if(nums[nums.length-1]-nums[i]<valueDifference)
            {
                break;
            }
            for(int j=nums.length-1;j>=i;j--)
            {
                if(nums[j]-nums[i]>=valueDifference)
                {
                    if(Math.abs(h2.get(nums[j])-h1.get(nums[i]))>=indexDifference)
                    {
                        result[0]=h1.get(nums[i]);
                        result[1]=h2.get(nums[j]);
                        flag=1;
                        break;
                    }
                    else if(Math.abs(h1.get(nums[j])-h2.get(nums[i]))>=indexDifference)
                    {
                        result[0]=h2.get(nums[i]);
                        result[1]=h1.get(nums[j]);
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==1)
            {
                break;
            }
        }
        
        return result;
        
        
    }
}
