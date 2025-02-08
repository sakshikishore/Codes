class Solution {
    public int minDeletion(int[] nums) {
        int i=0;
        int count=0;
       while(i<nums.length)
       {
        int j=i+1;
         if(j>=nums.length)
         {
            return count+1;
         }
         while(j<nums.length && nums[j]==nums[i])
         {
            count++;
            j++;
         }
         if(j==nums.length)
         {
            count++;
         }
         i=j+1;
       }

       return count;
    }
}
