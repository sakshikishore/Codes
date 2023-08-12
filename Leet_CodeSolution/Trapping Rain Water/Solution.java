class Solution {
    public int trap(int[] height) {
        int result=0;
        int maxLeft[]=new int[height.length];
        int max=0;
        for(int i=0;i<height.length;i++)
        {
            if(height[i]>max)
            {
                max=height[i];
            }
            maxLeft[i]=max;
        }
        max=0;
        int maxRight[]=new int[height.length];
        for(int i=height.length-1;i>=0;i--)
        {
            if(height[i]>max)
            {
                max=height[i];
            }
            maxRight[i]=max;
        }
        for(int i=0;i<height.length;i++)
        {
            result+=Math.min(maxLeft[i],maxRight[i])-height[i];
        }

        return result;


    }
}
