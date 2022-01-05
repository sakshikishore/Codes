class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        
        ArrayList<Boolean> l=new ArrayList<Boolean>();
        int p=0;
        for(int i=0;i<A.length;i++)
        {
            p=(p*2+A[i])%5;
            if(p==0)
            {
                l.add(true);
             }
            else
            {
                l.add(false);
            }
        }
        
        return l;
        
    }
}
