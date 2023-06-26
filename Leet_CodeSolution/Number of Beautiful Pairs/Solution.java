class Solution {
    public int countBeautifulPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                String s=Integer.toString(nums[i]);
                int a=Integer.parseInt(s.substring(0,1));
                int b=nums[j]%10;
                while(b!=0)
                {
                    int r=a%b;
                    a=b;
                    b=r;
                }
                if(a==1)
                {
                    count++;
                }
                
            }
        }
        
        return count;
    }
}
