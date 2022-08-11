class Solution {
    public String largestNumber(int[] nums) {
        String res="";
        long sum=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                String ij=Integer.toString(nums[i])+Integer.toString(nums[j]);
                String ji=Integer.toString(nums[j])+Integer.toString(nums[i]);
                if(ij.compareTo(ji)<0)
                {
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            res=res+Integer.toString(nums[i]);
        }
        if(sum==0)
        {
            res="0";
        }
        
        return res;
    }
}
