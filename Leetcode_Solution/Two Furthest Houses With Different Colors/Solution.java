class Solution {
    public int maxDistance(int[] colors) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int max=0;
        for(int i=0;i<colors.length;i++)
        {
            int p=colors[i];
            if(!l.contains(p))
            {
                l.add(p);
                for(int j=i+1;j<colors.length;j++)
                {
                     if(colors[j]!=p)
                     {
                         if(j-i>max)
                         {
                             max=j-i;
                         }
                     }
                }
            }
        }
        
        return max;
        
    }
}
