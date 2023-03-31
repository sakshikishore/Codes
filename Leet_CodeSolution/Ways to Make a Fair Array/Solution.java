class Solution {
    public int waysToMakeFair(int[] nums) {
        int evenPref[]=new int[nums.length];
        int oddPref[]=new int[nums.length];
        for(int i=0;i<nums.length;i=i+2)
        {
            if(i==0)
            {
                evenPref[i]=nums[i];
                if(i+1<nums.length)
                {
                evenPref[i+1]=nums[i];
                }
            }
            else
            {
                evenPref[i]=nums[i]+evenPref[i-1];
                if(i+1<nums.length)
                {
                  evenPref[i+1]=evenPref[i];
                }
            }
        }
         for(int i=1;i<nums.length;i=i+2)
        {
            if(i==1)
            {
                oddPref[i]=nums[i];
                if(i+1<nums.length)
                {
                 oddPref[i+1]=nums[i];
                }
            }
            else
            {
                oddPref[i]=nums[i]+oddPref[i-1];
                if(i+1<nums.length)
                {
                  oddPref[i+1]=oddPref[i];
                }
            }
        }

    int evenSum=evenPref[nums.length-1];
    int oddSum=oddPref[nums.length-1];
    int result=0;
    for(int i=0;i<nums.length;i++)
    {
        if(i==0)
        {
            int p=evenSum-nums[0];
            int q=oddSum;
            if(p==q)
            {
                result++;
            }
        }
        else if(i==nums.length-1)
        {
            if(nums.length%2==0)
            {
                int p=evenSum;
                int q=oddSum-nums[nums.length-1];
                if(p==q)
                {
                    result++;
                }
            }
            else
            {
                int p=evenSum-nums[nums.length-1];
                int q=oddSum;
                if(p==q)
                {
                    result++;
                }
            }
            
        }
        else
        {
            int p=evenPref[i-1]+oddSum-oddPref[i];
            int q=oddPref[i-1]+evenSum-evenPref[i];
            if(p==q)
            {
                result++;
            }
            
        }
    }

    return result;

    }
}
