class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list=new ArrayList();
        int count=1;
        int start=0;
        for(int i=1;i<S.length();i++)
        {
            if(S.charAt(i)==S.charAt(i-1))
            {
                count++;
            }
            else
            {
                if(count>2)
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(start);
                    l.add(i-1);
                    list.add(l);
                   
                }
                 count=1;
                 start=i;
              
            }
        }
        if(count>2)
        {
             ArrayList<Integer> l=new ArrayList<Integer>();
             l.add(start);
             l.add(S.length()-1);
             list.add(l);
        }
        
        return list;
        
    }
}
