class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        ArrayList<Integer> l=new ArrayList<Integer>();
       for(int i=0;i<groupSizes.length;i++)
       {
           if(!l.contains(groupSizes[i]))
           {
               l.add(groupSizes[i]);
           }
       }
        
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<l.size();i++)
        {
            ArrayList<Integer> p=new ArrayList<Integer>();
            for(int j=0;j<groupSizes.length;j++)
            {
                if(groupSizes[j]==l.get(i))
                {
                    p.add(j);
                }
                if(p.size()==l.get(i))
                {
                    list.add(p);
                    p=new ArrayList<Integer>();
                }
            }
        }
        
        return list;
        
    }
}
