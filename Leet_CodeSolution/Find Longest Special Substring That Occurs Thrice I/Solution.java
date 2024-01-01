class Solution {
    public int maximumLength(String s) {
        int max=-1;
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        for(int i=0;i<s.length();i++)
        {
            String str=s.substring(i,i+1);
            if(!h.containsKey(str))
            {
                h.put(str,1);
            }
            else
            {
                h.put(str,h.get(str)+1);
                if(h.get(str)>2)
                {
                    if(1>max)
                    {
                        max=1;
                    }
                }
            }
            for(int j=i+1;j<s.length();j++)
            {
               if(s.charAt(j)==s.charAt(j-1))
               {
                   str+=s.substring(j,j+1);
                   if(!h.containsKey(str))
                    {
                        h.put(str,1);
                    }
                    else
                    {
                        h.put(str,h.get(str)+1);
                        if(h.get(str)>2)
                        {
                            if(str.length()>max)
                            {
                                max=str.length();
                            }
                        }
                    }
               }
                else
                {
                    break;
                }
            }
        }
        
        return max;
    }
}
