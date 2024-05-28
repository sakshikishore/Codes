class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        if(k==nums.length)
        {
            return nums;
        }
        Stack<Integer> stck=new Stack<Integer>();
        stck.push(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            int flag=0;
            while(!stck.empty() && stck.peek()>nums[i])
            {
                if(nums.length-i+stck.size()-1>=k)
                {
                    flag=1;
                    stck.pop();
                }
                else
                {
                    break;
                }
            }
            if(flag==1)
            {
                stck.push(nums[i]);
            }
            else if(stck.size()<k)
            {
                 stck.push(nums[i]);
            }
        }

        int result[]=new int[k];
        while(!stck.empty())
        {
            result[k-1]=stck.pop();
            k--;
        }

        return result;
    }
}
