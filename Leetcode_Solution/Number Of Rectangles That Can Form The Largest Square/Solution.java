class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int count=0,max=0;
        for(int i=0;i<rectangles.length;i++)
        {
            int p=Math.min(rectangles[i][0],rectangles[i][1]);
            if(p>max)
            {
                max=p;
                count=1;
            }
            else if(p==max)
            {
                count++;
            }
        }
        
        return count;
    }
}
