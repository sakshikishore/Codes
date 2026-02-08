class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> stck=new Stack<Long>();
        stck.push(nums[0]*1l);
        for(int i=1;i<nums.length;i++)
        {
            long p=nums[i]*1l;
            while(!stck.empty() && p==stck.peek())
            {
                p=p+p;
                stck.pop();
            }
            stck.push(p);
        }

        ArrayList<Long> result=new ArrayList<Long>();
        while(!stck.empty())
        {
            result.add(0,stck.pop());
        }

        return result;
    }
}
