class Solution {
    public int[] rearrangeArray(int[] nums) {
      int result[]=new int[nums.length];
        Arrays.sort(nums);
        int k=0;
        int i=0,j=nums.length-1;
        while(i<j)
        {
            result[k]=nums[j];
            result[k+1]=nums[i];
            k=k+2;
            i++;
            j--;
        }
        if(i==j)
        {
            result[k]=nums[i];
        }
        
        return result;
    }
}
