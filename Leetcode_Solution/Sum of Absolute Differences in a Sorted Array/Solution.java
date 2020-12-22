class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int prev=0;
        int next=0;
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            next=next+nums[i];
        }
        for(int i=0;i<nums.length;i++)
        {
            next=next-nums[i];
            arr[i]=(i*nums[i]-prev)+(next-(nums.length-i-1)*nums[i]);
            prev=prev+nums[i];
        }
        return arr;
        
    }
}
