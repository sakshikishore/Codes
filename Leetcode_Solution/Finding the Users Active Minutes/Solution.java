class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int result[]=new int[k];
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<logs.length;i++)
        {
            if(!l.contains(logs[i][0]))
            {
                l.add(logs[i][0]);
            }
        }
        for(int i=0;i<l.size();i++)
        {
            ArrayList<Integer> p=new ArrayList<Integer>();
            for(int j=0;j<logs.length;j++)
            {
                if(logs[j][0]==l.get(i))
                {
                    if(!p.contains(logs[j][1]))
                    {
                        p.add(logs[j][1]);
                    }
                }
            }
            result[p.size()-1]++;
        }
        
       
        
        return result;
    }
}
