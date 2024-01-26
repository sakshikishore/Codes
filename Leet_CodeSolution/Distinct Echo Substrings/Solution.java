class Solution {
    public int distinctEchoSubstrings(String text) {
        TreeSet<String> t=new TreeSet<String>();
        for(int i=0;i<text.length();i++)
        {
            for(int j=i+2;j<=text.length();j=j+2)
            {
                    String s=text.substring(i,j);
                    if(!t.contains(s))
                    {
                        String a=s.substring(0,s.length()/2);
                        String b=s.substring(s.length()/2);
                        if(a.equals(b))
                        {
                            t.add(s);
                        }
                    }
            }
        }
            
            return t.size();
    }
}
