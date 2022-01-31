class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        int a=0;  // for 0's count
        int b=0; // for 1's count
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                b++;
            }
        }
        int q=b;
        int p=b;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                a++;
            }
            else
            {
                b--;
            }
            
            if(b+a>p)
            {
                p=a+b;
            }
        }
        a=0;  
        if(q==p)
        {
            result.add(0);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                a++;
            }
            else
            {
                q--;
            }
            
            if(q+a==p)
            {
                result.add(i+1);
            }
        }
        
        return result;
        
    }
}
