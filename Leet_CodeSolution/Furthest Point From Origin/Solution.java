class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int r=0,l=0;
        for(int i=0;i<moves.length();i++)
        {
            if(moves.charAt(i)=='R')
            {
                r++;
            }
            else if(moves.charAt(i)=='L')
            {
                l++;
            }
        }
        int min=Math.min(l,r);
        
        return moves.length()-2*min;
        
    }
}
