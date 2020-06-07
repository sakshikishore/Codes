class Solution {
    public String destCity(List<List<String>> paths) {
        ArrayList<String> l=new ArrayList<String>();;
        ArrayList<String> p=new ArrayList<String>();
        l.add(paths.get(0).get(0));
        p.add(paths.get(0).get(1));
        
        String result="";
        
        for(int i=1;i<paths.size();i++)
        {
          String a=paths.get(i).get(0);
          String b=paths.get(i).get(1);
            if(p.contains(a))
            {
                p.remove(a);
            }
            l.add(a);
            if(!l.contains(b))
            {
                p.add(b);
            }
        }
        
        result=p.get(0);
        
        return result;
        
    }
}
