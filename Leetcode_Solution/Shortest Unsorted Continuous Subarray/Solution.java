class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int result=0;
       int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=nums[i];
        }
        
        Arrays.sort(arr);
        
        int l=-1,r=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=arr[i])
            {
                if(l==-1)
                {
                    l=i;
                }
            }
            if(nums[nums.length-1-i]!=arr[nums.length-1-i])
            {
                if(r==-1)
                {
                    r=nums.length-1-i;
                }
            }
            if(r!=-1 && l!=-1)
            {
                break;
            }
        }
        if(l!=-1 && r!=-1)
        {

            if(l==r)
            {
                result=1;
            }
            else
            {
                result=r-l+1;
            }
            
        }
        
        return result;
        
    }
}
