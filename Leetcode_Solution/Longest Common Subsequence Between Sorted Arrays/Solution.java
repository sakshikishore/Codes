class Solution {
    public List<Integer> longestCommomSubsequence(int[][] arrays) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int min=arrays[0].length;
        int index=0;
        for(int i=1;i<arrays.length;i++)
        {
            if(arrays[i].length<min)
            {
                min=arrays[i].length;
                index=i;
            }
        }
        for(int i=0;i<arrays[index].length;i++)
        {
            int count=0;
            for(int j=0;j<arrays.length;j++)
            {
                for(int k=0;k<arrays[j].length;k++)
                {
                    if(arrays[index][i]==arrays[j][k])
                    {
                        count++;
                    }
                }
            }
            if(count==arrays.length)
            {
                l.add(arrays[index][i]);
            }
        }
        
        return l;
        
    }
}
