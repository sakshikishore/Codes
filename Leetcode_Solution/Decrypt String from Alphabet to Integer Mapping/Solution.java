class Solution {
    public String freqAlphabets(String s) {
        String str="";
        HashMap<String,Character> h=new HashMap<String,Character>();
        for(int i=0;i<26;i++)
        {
            if(i>=0 && i<9)
            {
            h.put(Integer.toString(i+1),(char)(97+i));
            }
            else
            {
                String p=Integer.toString(i+1)+"#";
                h.put(p,(char)(97+i));
            }
        }
        int i=0;
        while(i<s.length())
        {
            if(s.charAt(i)>'2')
            {
                str=str+Character.toString(h.get(s.substring(i,i+1)));
                i++;
            }
            else
            {
                if(i+2<s.length())
                {
                    if(s.charAt(i+2)=='#')
                    {
                          str=str+Character.toString(h.get(s.substring(i,i+3)));
                          i=i+3;
                    }
                    else
                    {
                       str=str+Character.toString(h.get(s.substring(i,i+1)));
                       i++;
                    }
                }
                else
                {
                        str=str+Character.toString(h.get(s.substring(i,i+1)));
                        i++;
                }
            }
        }
        return str;
        
    }
}
