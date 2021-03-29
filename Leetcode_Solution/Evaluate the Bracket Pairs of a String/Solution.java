class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> h=new HashMap<String,String>();
        for(int i=0;i<knowledge.size();i++)
        {
            h.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        String str="";
        String p="";
        int l=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                l=1;           
            }
           else if(s.charAt(i)==')')
            {
                l=0;
                if(h.containsKey(p))
                {
                    str=str+h.get(p);
                }
                else
                {
                    str=str+"?";
                }
                p="";
            }
            else if(l==1)
            {
                p=p+s.substring(i,i+1);
            }
            else
            {
                str=str+s.substring(i,i+1);
            }
            
        }
        
        return str;
        
    }
}
