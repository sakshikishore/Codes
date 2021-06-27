class Solution {
    public boolean canBeIncreasing(int[] nums) {
        boolean result=true;
        int count=0;
        int a=-1,b=-1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<=nums[i-1])
            {
                count++;
                a=i;
                b=i-1;
                break;
            }
        }
        if(count==1)
        {
        // remove a
        count=0;
        int j=0;
        int arr[]=new int[nums.length-1];
        for(int i=0;i<nums.length;i++)
        {
            if(i!=a)
            {
                arr[j]=nums[i];
                j++;
            }
        }
        
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<=arr[i-1])
            {
                count++;
                break;
            }
        }
        if(count==1)
        {
            j=0;
             for(int i=0;i<nums.length;i++)
             {
                    if(i!=b)
                    {
                        arr[j]=nums[i];
                        j++;
                    }
             }
             for(int i=1;i<arr.length;i++)
                {
                    if(arr[i]<=arr[i-1])
                    {
                        result=false;
                        break;
                    }
                }
        }
        }
        return result;
    }
}
