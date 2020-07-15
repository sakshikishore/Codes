class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int result=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int sum=nums[i];
            l.add(sum);
            for(int j=i+1;j<nums.length;j++)
            {
                sum=sum+nums[j];
                l.add(sum);
            }
        }
        
        Collections.sort(l);
        for(int i=left-1;i<right;i++)
        {
           
            result=result+l.get(i);
        }
        
        return result;
        
    }
}
