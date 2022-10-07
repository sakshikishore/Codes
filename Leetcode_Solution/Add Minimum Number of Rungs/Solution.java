class Solution {
    public int addRungs(int[] rungs, int dist) {
        int count=0;
        int pos=0;
        for(int i=0;i<rungs.length;i++)
        {
            int x=rungs[i]-pos;
            if(x!=dist)
            {
                x=x-1;
             count+=x/dist;
            }
            pos=rungs[i];
        }
        return count;
    }
}
