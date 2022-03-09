class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean result=false;
        int xDistance=Math.min(rec1[2],rec2[2])-Math.max(rec1[0],rec2[0]);
        int yDistance=Math.min(rec1[3],rec2[3])-Math.max(rec1[1],rec2[1]);
        if(xDistance>0 && yDistance>0)
        {
            result=true;
        }
        
        return result;
    }
}
