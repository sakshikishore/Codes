class Solution {
    public int subarraySum(int[] nums) {
        int sum=0;
       int pref[]=new int[nums.length];
       pref[0]=nums[0]; 
       for(int i=1;i<nums.length;i++)
       {
        pref[i]=nums[i]+pref[i-1];
       }
       for(int i=0;i<nums.length;i++)
       {
         int start=Math.max(0,i-nums[i]);
         if(start==0)
         {
            sum+=pref[i];
         }
         else
         {
            sum=sum+(pref[i]-pref[start-1]);
         }
       }

       return sum;
    }
}
