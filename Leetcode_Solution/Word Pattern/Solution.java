class Solution {
    public boolean wordPattern(String pattern, String str) {
        boolean result=true;
        String p[]=str.split(" ");
        if(p.length!=pattern.length())
        {
            result=false;
        }
        else
        {
            HashMap<Character,String> h=new HashMap<Character,String>();
            ArrayList<String> l=new ArrayList<String>();
            for(int i=0;i<pattern.length();i++)
            {
                if(!h.containsKey(pattern.charAt(i)))
                {
                    if(!l.contains(p[i]))
                    {
                    h.put(pattern.charAt(i),p[i]);
                        l.add(p[i]);
                    }
                    else
                    {
                        result=false;
                        break;
                    }
                    
                }
                else
                {
                    String t=h.get(pattern.charAt(i));
                    if(!t.equals(p[i]))
                    {
                        result=false;
                        break;
                    }
                }
            }
        }
        return result;
        
    }
}
