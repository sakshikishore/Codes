class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1)
        {
            return 1;
        }
        int arr[]=new int[nums.length-1];
        for(int i=1;i<nums.length;i++)
        {
            arr[i-1]=nums[i]-nums[i-1];
        }
        int max=1;
    
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
            int turn=0;
            int count=1;
            if(arr[i]>0)
            {
                turn=-1;
            }
            else
            {
                turn=1;
            }
            for(int j=i-1;j>=0;j--)
            {
                if(arr[j]<0 && turn==-1)
                {
                    count++;
                    turn=1;
                }
                else if(arr[j]>0 && turn==1)
                {
                    count++;
                    turn =-1;
                }
            }
            if(count+1>max)
            {
                max=count+1;
            }
            }
        }
        
        return max;
    }
}
