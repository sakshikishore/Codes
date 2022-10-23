class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            int a=nums[i];
            if(a==k)
            {
                count++;
            }
            for(int j=i+1;j<nums.length;j++)
            {
                int b=nums[j];
                while(b!=0)
                {
                    int r=a%b;
                    a=b;
                    b=r;
                }
                if(a==k)
                {
                    count++;
                }
                else if(a<k)
                {
                    break;
                }
            }
        }
        
        return count;
    }
}
