class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
       String res="";
       String str[]=sentence.split(" ");
        HashMap<String,String> h=new HashMap<String,String>();
        for(int i=0;i<dictionary.size();i++)
        {
            String s=dictionary.get(i);
            for(int j=0;j<str.length;j++)
            {
                
                if(s.length()<=str[j].length())
                {
                    if(str[j].substring(0,s.length()).equals(s))
                    {
                        if(!h.containsKey(str[j]))
                        {
                            h.put(str[j],s);
                        }
                        else
                        {
                            if(s.length()<h.get(str[j]).length())
                            {
                                 h.put(str[j],s);
                            }
                        }
                    }
                }
            }
        }
        String result="";
        for(int i=0;i<str.length;i++)
        {
            if(h.containsKey(str[i]))
            {
                if(result.length()==0)
                {
                      result=result+h.get(str[i]);
                }
                else
                {
                result=result+" "+h.get(str[i]);
                }
            }
            else
            {
                 if(result.length()==0)
                 {
                     result+=str[i];
                 }
                else
                {
                 result=result+" "+str[i];
                }
            }
        }
        return result;
        
    }
}
