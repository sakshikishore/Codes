class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int max=0;
        while(i<j)
        {
            int min=Math.min(height[i],height[j]);
            int area=min*(j-i);
            if(area>max)
            {
                max=area;
                
            }
            if(height[i]>height[j])
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return max;
    }
}
