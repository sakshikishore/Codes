class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result=new ArrayList();
        for(int i=1;i<=1000;i++)
        {
            for(int j=1;j<=1000;j++)
            {
                int val=customfunction.f(i,j);
                if(val==z)
                {
                    ArrayList<Integer> list=new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
           }        
        }

        return result;
    }
}
