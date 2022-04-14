class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
       HashMap<String,String> h=new HashMap<String,String>();
        List<List<String>> list=new ArrayList();
        for(int x=0;x<paths.length;x++)
        {
           String str[]=paths[x].split(" ");
           for(int i=1;i<str.length;i++)
           {
               int a=str[i].indexOf("(");
               String j=str[i].substring(0,a);
               String k=str[i].substring(a+1,str[i].length()-1);
               if(!h.containsKey(k))
               {
                   h.put(k,str[0]+"/"+j);
               }
               else
               {
                   h.put(k,h.get(k)+","+str[0]+"/"+j);
               }
           }
        }
        for (Map.Entry<String,String> entry : h.entrySet())
        {
            String p=entry.getValue();
            if(p.contains(","))
            {
                String s[]=p.split(",");
                ArrayList<String> l=new ArrayList<String>();
                for(int i=0;i<s.length;i++)
                {
                    l.add(s[i]);
                }
                
                list.add(l);
            }
        }
        
        return list;
    }
}
