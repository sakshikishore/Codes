class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++)
        {
            ArrayList<Integer> p=new ArrayList<Integer>();
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)
                {
                    p.add(1);
                }
                else
                {
                    p.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
                }
            }
            list.add(p);
        }
        
        return list.get(rowIndex);
        
    }
}
