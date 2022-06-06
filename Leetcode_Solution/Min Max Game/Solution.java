class Solution {
    public int minMaxGame(int[] nums) {
        while(nums.length>1)
        {
            int n=nums.length;
            int arr[]=new int[n/2];
            for(int i=0;i<arr.length;i++)
            {
                if(i%2==0)
                {
                   arr[i]=Math.min(nums[2*i],nums[(2*i)+1]);
                }
                else
                {
                    arr[i]=Math.max(nums[2*i],nums[(2*i)+1]);
                }
            }
            nums=new int[arr.length];
            nums=arr;
        }
        
        return nums[0];
        
    }
}
