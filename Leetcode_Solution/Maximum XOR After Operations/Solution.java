class Solution {
    public int maximumXOR(int[] nums) {
        Arrays.sort(nums);
        String str=Integer.toBinaryString(nums[nums.length-1]);
        int arr[]=new int[str.length()];
        for(int i=0;i<nums.length;i++)
        {
            int n=0;
            while(nums[i]!=0)
            {
                int a=(nums[i] & 1);
                arr[n]+=a;
                nums[i]>>=1;
                n++;
                
            }
        }
        String result="";
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>0)
            {
                result="1"+result;
            }
            else
            {
                result="0"+result;
            }
        }
        
        return Integer.parseInt(result,2);
    }
}
