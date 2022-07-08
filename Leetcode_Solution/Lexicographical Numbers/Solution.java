class Solution {
    public List<Integer> lexicalOrder(int n) {
        TreeSet<String> t=new TreeSet<String>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=1;i<=n;i++)
        {
            t.add(Integer.toString(i));
        }
        
        Iterator<String> itr=t.iterator();
        while(itr.hasNext())
        {
            String s=itr.next();
            l.add(Integer.parseInt(s));
        }
        
        return l;
    }
}
