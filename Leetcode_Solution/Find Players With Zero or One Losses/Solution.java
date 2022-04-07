class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int winner[]=new int[100001];
        int looser[]=new int[100001];
        List<List<Integer>> list=new ArrayList();
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> m=new ArrayList<Integer>();
        for(int i=0;i<matches.length;i++)
        {
            winner[matches[i][0]]++;
            looser[matches[i][1]]++;
        }
        
        for(int i=1;i<100001;i++)
        {
            if(winner[i]>0 && looser[i]==0)
            {
                l.add(i);
            }
            if(looser[i]==1)
            {
                m.add(i);
            }
        }
        
        list.add(l);
        list.add(m);
        
        return list;
        
    }
}
