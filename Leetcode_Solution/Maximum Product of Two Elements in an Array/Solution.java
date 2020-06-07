class Solution {
    public int maxProduct(int[] nums) {
        int maxElement=nums[0];
        int maxIndex=0;
        for(int i=1;i<nums.length;i++)
        {
            if(maxElement<nums[i])
            {
                maxElement=nums[i];
                maxIndex=i;
            }
        }
        int secondMaxElement=0;
        if(maxIndex!=0)
        {
          secondMaxElement=nums[0];
        }
        else
        {
            secondMaxElement=nums[1];
        }

         for(int i=0;i<nums.length;i++)
        {
            if(secondMaxElement<nums[i] && i!= maxIndex)
            {
                secondMaxElement=nums[i];
          
            }
        }
        
        return (maxElement-1)*(secondMaxElement-1);
        
    }
}
