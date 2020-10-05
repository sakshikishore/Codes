class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        ArrayList<String> l=new ArrayList<String>();
        for(int i=0;i<cpdomains.length;i++)
        {
            String p[]=cpdomains[i].split("\\.");
            int total= Integer.parseInt(p[0].split(" ")[0]);
            p[0]=p[0].split(" ")[1];
            String str="";
            for(int j=p.length-1;j>=0;j--)
            {
                str=p[j]+str;
                if(!h.containsKey(str))
                {
                    h.put(str,total);
                    
                }
                else
                {
                    h.put(str,h.get(str)+total);
                }
                
                str="."+str;
            }
        }
        
        for(Map.Entry<String,Integer> m:h.entrySet())
        {
            String k=m.getValue()+" "+m.getKey();
            l.add(k);
        }
        
        return l;
    }
}
