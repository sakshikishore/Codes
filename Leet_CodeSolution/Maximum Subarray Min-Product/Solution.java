class Solution {
    public int maxSumMinProduct(int[] nums) {
        long result=0;
        long prefSum[]=new long[nums.length];
        prefSum[0]=nums[0];
         int prevClosestSmallerElementIndex[]=new int[nums.length];
          Stack<Integer> stck=new Stack<Integer>();
          stck.push(-1);
          prevClosestSmallerElementIndex[0]=-1;
          stck.push(0);
        for(int i=1;i<nums.length;i++)
        {
            prefSum[i]=prefSum[i-1]+nums[i];
            while(stck.size()>1 && nums[stck.peek()]>=nums[i])
            {
                stck.pop();
            }
            prevClosestSmallerElementIndex[i]=stck.peek();
            stck.push(i);
        }
        long sufSum[]=new long[nums.length];
        sufSum[nums.length-1]=nums[nums.length-1];
         int nextSmallerElementIndex[]=new int[nums.length];
         stck=new Stack<Integer>();
         stck.push(-1);
         stck.push(nums.length-1);
         nextSmallerElementIndex[nums.length-1]=-1;
        for(int i=nums.length-2;i>=0;i--)
        {
            sufSum[i]=sufSum[i+1]+nums[i];
            while(stck.size()>1 && nums[stck.peek()]>=nums[i])
            {
                stck.pop();
            }
            nextSmallerElementIndex[i]=stck.peek();
            stck.push(i);

        }
        for(int i=0;i<nums.length;i++)
        {
            long sum=0;
            if(prevClosestSmallerElementIndex[i]==-1)
            {
                sum=prefSum[i];
            }
            else
            {
                sum=prefSum[i]-prefSum[prevClosestSmallerElementIndex[i]];
            }
            if(nextSmallerElementIndex[i]==-1)
            {
                if(i+1<nums.length)
                {
                sum+=sufSum[i+1];
                }
            }
            else
            {
                sum+=sufSum[i+1]-sufSum[nextSmallerElementIndex[i]];
            }
            sum=sum*nums[i];
            if(sum>result)
            {
                result=sum;
            }
        }

        return (int)(result%(1000000007));

    }
}
