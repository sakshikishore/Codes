class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        if(nums[0]>x && nums[nums.length-1]>x)
        {
            return -1;
        }
        
        int sum=0;
        for(int i=nums.length-1;i>=0;i--)
        {
            sum+=nums[i];
            map.put(sum,i);
        }
        int result=Integer.MAX_VALUE;
         sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(i==0)
            {
                if(map.containsKey(x))
                {
                    result=nums.length-map.get(x);
                }
            }
            else
            {
                int val=sum-nums[i];
                if(val>x)
                {
                    break;
                }
                else
                {
                    if(val==x)
                    {
                        if(i<result)
                        {
                            result=i;
                        }
                    }
                    else
                    {
                        val=x-val;
                        if(map.containsKey(val) && map.get(val)>=i)
                        {
                            int ans=i+(nums.length-map.get(val));
                            if(ans<result)
                            {
                                result=ans;
                            }
                        }
                    }
                }
            }
        }
        if(result==Integer.MAX_VALUE)
        {
            return -1;
        }

        return result;
    }
}
