class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int x=Math.abs(target[0])+Math.abs(target[1]);
        for(int i=0;i<ghosts.length;i++)
        {
            int a=ghosts[i][0]-target[0];
            int b=ghosts[i][1]-target[1];
            int y=Math.abs(a)+Math.abs(b);
            if(x>=y)
            {
                return false;
            }
        }
        
        return true;
        
    }
}
