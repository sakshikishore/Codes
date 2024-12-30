class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int prev[]=new int[nums.length];
        int next[]=new int[nums.length];
        Stack<Integer> stck=new Stack<Integer>();
        stck.push(-1);
        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]>threshold)
            {
                return 1;
            }
            while(stck.peek()!=-1 && nums[stck.peek()]>=nums[i])
            {
                stck.pop();
            }
            next[i]=stck.peek();
            stck.push(i);
        }
         stck=new Stack<Integer>();
         stck.push(-1);
         for(int i=0;i<nums.length;i++)
         {
             while(stck.peek()!=-1 && nums[stck.peek()]>=nums[i])
            {
                stck.pop();
            }
            prev[i]=stck.peek();
            stck.push(i);
         }
         for(int i=0;i<nums.length;i++)
         {
                  
                    int total=i-prev[i];
                    if(next[i]==-1)
                    {
                        total+=nums.length-1-i;
                    }
                    else
                    {
                        total+=next[i]-i-1;
                    }
                   if(threshold/total<nums[i])
                   {
                       return total;
                   }
                
            
         }
     return -1;
         
    }
}
