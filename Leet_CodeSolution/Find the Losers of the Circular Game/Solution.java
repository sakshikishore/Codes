class Solution {
    public int[] circularGameLosers(int n, int k) {
        HashSet<Integer> h=new HashSet<Integer>();
        int friend=1;
        int i=1;
        while(!h.contains(friend))
        {
            h.add(friend);
            friend=(friend+(i*k))%n;
            if(friend==0)
            {
                friend=n;
            }
            i++; 
        }
        int result[]=new int[n-h.size()];
        int p=0;
        for(i=1;i<=n;i++)
        {
            if(!h.contains(i))
            {
                result[p]=i;
                p++;
            }
        }
        
        return result;
    }
}
