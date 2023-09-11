class Solution {
    public int largestRectangleArea(int[] heights) {
        int max=0;
        Stack<Integer> stck=new Stack<Integer>();
        stck.push(-1);
        int result[]=new int[heights.length];
        for(int i=0;i<heights.length;i++)
        {
            while(stck.peek()!=-1 && heights[stck.peek()]>=heights[i])
            {
                stck.pop();
            }
            result[i]=(i-stck.peek())*heights[i];
            stck.push(i);
        }
        stck.clear();
        stck.push(heights.length);
        for(int i=heights.length-1;i>=0;i--)
        {
            while(stck.peek()!=heights.length && heights[stck.peek()]>=heights[i])
            {
                stck.pop();
            }
            result[i]+=(stck.peek()-i-1)*heights[i];
            if(result[i]>max)
            {
                max=result[i];
            }
            stck.push(i);
        }

        return max;

    }
}
