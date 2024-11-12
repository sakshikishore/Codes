class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int arr[]=new int[nums.size()];
        int k=1;
        arr[nums.size()-1]=1;
        for(int i=nums.size()-2;i>=0;i--)
        {
            if(nums.get(i)<nums.get(i+1))
            {
                arr[i]=arr[i+1]+1;
            }
            else
            {
                arr[i]=1;
            }
        }
       int a[]=new int[nums.size()];
       a[0]=1;
       for(int i=1;i<nums.size();i++)
       {
         if(nums.get(i)>nums.get(i-1))
         {
            a[i]=a[i-1]+1;
            if(i+1<nums.size())
            {
              int min=Math.min(a[i],arr[i+1]);
              k=Math.max(k,min);
            }
         }
         else
         {
            a[i]=1;
         }
       }

       return k;

    }
}
