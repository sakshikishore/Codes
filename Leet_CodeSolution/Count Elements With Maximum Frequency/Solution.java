class Solution {
    public int maxFrequencyElements(int[] nums) {
        int ch[]=new int[101];
        int max=0,result=0;
        for(int i=0;i<nums.length;i++)
        {
            ch[nums[i]]++;
            if(ch[nums[i]]>max)
            {
                max=ch[nums[i]];
            }
        }
        for(int i=1;i<=100;i++)
        {
            if(ch[i]==max)
            {
                result+=max;
            }
        }
        
        return result;
    }
}
