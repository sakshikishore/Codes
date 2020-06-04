class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0;
        int i=0;
        int count=0;
        if(g.length>0 && s.length>0)
        {
        while(j!=s.length || i!=g.length)
        {
            if(s[j]>=g[i])
            {
                count++;
                i++;
                if(i==g.length)
                {
                    break;
                }
               
            }
            
           j++;
            if(j==s.length)
            {
                break;
            }
        }
        }
        
        return count;
        
    }
}
