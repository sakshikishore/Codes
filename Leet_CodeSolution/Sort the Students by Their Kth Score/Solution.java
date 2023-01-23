class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int result[][]=new int[score.length][score[0].length];
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<score.length;i++)
        {
            l.add(score[i][k]);
            h.put(score[i][k],i);
            
        }
        
        Collections.sort(l);
        int x=0;
        for(int i=l.size()-1;i>=0;i--)
        {
            int index=h.get(l.get(i));
            for(int j=0;j<score[0].length;j++)
            {
                result[x][j]=score[index][j];
            }
            x++;
            
        }
        return result;
        
    }
}
