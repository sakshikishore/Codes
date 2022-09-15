class WordFilter {

    HashMap<String,Integer> h=new HashMap<String,Integer>();
    public WordFilter(String[] words) {
        for(int l=words.length-1;l>=0;l--)
        {
            char c[]=words[l].toCharArray();
            String suff[]=new String[c.length];
             String s="";
             String str="";
             for(int j=c.length-1;j>=0;j--)
                {
                    str=Character.toString(c[j])+str;
                    suff[j]=str;
                }
            for(int i=0;i<c.length;i++)
            {
                s=s+Character.toString(c[i]);
                for(int j=c.length-1;j>=0;j--)
                {
                    String k=s+" "+suff[j];
                    if(!h.containsKey(k))
                    {
                        h.put(k,l);
                    }
                }
            }
            
        }
    }
    
    public int f(String prefix, String suffix) {
       String s=prefix+" "+suffix;
       if(h.containsKey(s))
       {
           return h.get(s);
       }
        return -1;
    }
}
