class Solution {
    public long findMaximumScore(List<Integer> nums) {
        Stack<Integer> stck=new Stack<Integer>();
        stck.push(nums.size()-1);
        long res[]=new long[nums.size()];
        for(int i=nums.size()-1;i>=0;i--)
        {
            while(stck.size()>0)
            {
               int x=stck.peek();
               if(nums.get(x)>nums.get(i))
               {
                  res[i]=((x-i)*(nums.get(i)*1L))+res[x];
                  break;
               }
               else
               {
                 stck.pop();
               }
            }

            if(stck.size()==0)
            {
                res[i]=((nums.size()-1-i)*(nums.get(i)*1L));
            }
            stck.push(i);
        }

        return res[0];
    }
}
