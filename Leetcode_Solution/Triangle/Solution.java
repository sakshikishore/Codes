class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result=triangle.get(0).get(0);
        if(triangle.size()==1)
        {
            return result;
        }
        List<ArrayList<Integer>> list=new ArrayList();
        
        for(int i=0;i<triangle.size();i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            list.add(l);
        }
        list.get(0).add(triangle.get(0).get(0));
        int min=Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++)
        {
            for(int j=0;j<triangle.get(i).size();j++)
            {
                int x=0;
                if(j==0)
                {
                    x=list.get(i-1).get(0)+triangle.get(i).get(0);
                    list.get(i).add(x);
                }
                else if(j==triangle.get(i).size()-1)
                {
                    x=list.get(i-1).get(j-1)+triangle.get(i).get(j);
                    list.get(i).add(x);
                }
                else
                {
                    x=Math.min(list.get(i-1).get(j),list.get(i-1).get(j-1));
                    x=x+triangle.get(i).get(j);
                    list.get(i).add(x);
                }
                
                if(i==triangle.size()-1)
                {
                    if(x<min)
                    {
                        min=x;
                    }
                }
            }
        }
        
        return min;
    }
}
