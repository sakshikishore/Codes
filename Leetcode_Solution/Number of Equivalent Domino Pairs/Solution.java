class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<dominoes.length;i++)        
        {
            int a=Math.max(dominoes[i][0],dominoes[i][1]);
            int b=Math.min(dominoes[i][0],dominoes[i][1]);
            int j=a*10+b;
            if(!h.containsKey(j))
            {
                h.put(j,1);
            }
            else
            {
                h.put(j,h.get(j)+1);
            
            }
        }
         for(int i=0;i<dominoes.length;i++)
         {
            int a=Math.max(dominoes[i][0],dominoes[i][1]);
            int b=Math.min(dominoes[i][0],dominoes[i][1]);
            int j=a*10+b;
            if(h.containsKey(j))
            {
                int p=h.get(j)-1;
                count=count+((p*(p+1))/2);
                h.remove(j);
            }
            
         }
        
        return count;
        
    }
}
