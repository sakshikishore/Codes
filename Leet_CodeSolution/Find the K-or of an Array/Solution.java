class Solution {
    public int findKOr(int[] nums, int k) {
        Arrays.sort(nums);
        String str=Integer.toBinaryString(nums[nums.length-1]);
        int arr[]=new int[str.length()];
        for(int i=0;i<nums.length;i++)
        {
            str=Integer.toBinaryString(nums[i]);
            int c=0;
            for(int j=str.length()-1;j>=0;j--)
            {
                if(str.charAt(j)=='1')
                {
                    arr[c]++;
                }
                c++;
            }
        }
        int result=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>=k)
            {
                result+=(int)Math.pow(2,i);
            }
        }
        
        return result;
    }
}
