class Solution {
    public long[] distance(int[] nums) {
        long leftSum[]=new long[nums.length];
        long leftCount[]=new long[nums.length];
        HashMap<Integer,Integer> hleft=new HashMap<Integer,Integer>();
        long rightSum[]=new long[nums.length];
        long rightCount[]=new long[nums.length];
        HashMap<Integer,Integer> hright=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!hleft.containsKey(nums[i]))
            {
                hleft.put(nums[i],i);
                leftCount[i]=0;
                leftSum[i]=0;
            }
            else
            {
                int x=hleft.get(nums[i]);
                leftCount[i]=leftCount[x]+1;
                leftSum[i]=leftSum[x]+x;
                hleft.put(nums[i],i);
            }
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            if(!hright.containsKey(nums[i]))
            {
                hright.put(nums[i],i);
                rightCount[i]=0;
                rightSum[i]=0;
            }
            else
            {
                int x=hright.get(nums[i]);
                rightCount[i]=rightCount[x]+1;
                rightSum[i]=rightSum[x]+x;
                hright.put(nums[i],i);
            }
        }

        long result[]=new long[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            result[i]=((leftCount[i]*i)-leftSum[i]) +(rightSum[i]-(rightCount[i]*i));
        }

        return result;
    }
}
