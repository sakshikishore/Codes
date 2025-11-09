class Solution {
    public int minimumDistance(int[] nums) {
        if(nums.length<3)
        {
            return -1;
        }
        HashMap<Integer,Stack<Integer>> h=new HashMap<Integer,Stack<Integer>>();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                Stack<Integer> stck=new Stack<Integer>();
                stck.push(i);
                h.put(nums[i],stck);
            }
            else
            {
                Stack<Integer> stck=h.get(nums[i]);
                if(stck.size()<2)
                {
                    stck.push(i);
                    h.put(nums[i],stck);
                }
                else
                {
                    int b=stck.pop();
                    int a=stck.pop();
                    int p=(i-a)+(b-a)+(i-b);
                    if(p<ans)
                    {
                        ans=p;
                    }
                    stck.push(b);
                    stck.push(i);
                    h.put(nums[i],stck);
                }
            }
        }
        if(ans==Integer.MAX_VALUE)
        {
            return -1;
        }

        return ans;
    }
}
