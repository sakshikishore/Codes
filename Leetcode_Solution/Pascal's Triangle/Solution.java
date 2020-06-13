class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();    
        for(int i=0;i<numRows;i++)
        {
            ArrayList p=new ArrayList<Integer>();
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
        
        return list;
    }
}
