class Solution {
    public String reformat(String s) {
        char ch[]=s.toCharArray();
        String result="";
        ArrayList<Character> l=new ArrayList<Character>();
       ArrayList<Character> p=new ArrayList<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(ch[i]>='0' && ch[i]<='9')
            {
                l.add(ch[i]);
            }
            else
            {
                p.add(ch[i]);
            }
        }
        if(ch.length%2==0)
        {
            if(l.size()==p.size())
            {
                for(int i=0;i<l.size();i++)
                {
                    result=result+Character.toString(l.get(i))+Character.toString(p.get(i));
                }
            }
            
        }
        else
        {
            if(Math.abs(l.size()-p.size())==1)
            {
                if(l.size()>p.size())
                {
                    for(int i=0;i<p.size();i++)
                    {
                     result=result+Character.toString(l.get(i))+Character.toString(p.get(i));
                    }
                    result=result+l.get(l.size()-1);
                }
                else
                {
                     for(int i=0;i<l.size();i++)
                     {
                      result=result+Character.toString(p.get(i))+Character.toString(l.get(i));
                     }
                    result=result+p.get(p.size()-1);
                }
            }
            
        }
        return result;
        
    }
}
