class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String,String> h1=new HashMap<String,String>();
        HashMap<String,String> h2=new HashMap<String,String>();
        HashSet<String> hset=new HashSet<String>();
        for(int i=0;i<wordlist.length;i++)
        {
            String s=wordlist[i].toLowerCase();
            String str="";
            if(!h1.containsKey(s))
            {
                h1.put(s,wordlist[i]);
            }
            char c[]=s.toCharArray();
            hset.add(wordlist[i]);
            for(int j=0;j<c.length;j++)
            {
                if(c[j]=='a' || c[j]=='e' || c[j]=='i' || c[j]=='o' || c[j]=='u') 
                {
                    str=str+"a";
                }
                else
                {
                    str=str+Character.toString(c[j]);
                }
            }
            if(!h2.containsKey(str))
            {
                h2.put(str,wordlist[i]);
            }
        }
        for(int i=0;i<queries.length;i++)
        {
            if(!hset.contains(queries[i]))
            {
                String t=queries[i].toLowerCase();
                if(h1.containsKey(t))
                {
                    queries[i]=h1.get(t);
                }
                else
                {
                    String p="";
                    char c[]=queries[i].toLowerCase().toCharArray();
                    for(int j=0;j<c.length;j++)
                    {
                        if(c[j]=='a' || c[j]=='e' || c[j]=='i' || c[j]=='o' || c[j]=='u') 
                        {
                            p=p+"a";
                        }
                        else
                        {
                            p=p+Character.toString(c[j]);
                        }
                    }
                    
                    if(h2.containsKey(p))
                    {
                        queries[i]=h2.get(p);
                    }
                    else
                    {
                        queries[i]="";
                    }
                     
                }
            }
        }
        
        return queries;
    }
}
