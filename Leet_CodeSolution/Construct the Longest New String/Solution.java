class Solution {
    public int longestString(int x, int y, int z) {
        
        if(x==y)
        {
            return 2*(x+y+z);
        }
        else
        {
            int p=(int)Math.min(x,y);
            return (4*p)+(z*2)+2;
        }
    }
}
