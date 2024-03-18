class Solution {
    public boolean isSubstringPresent(String s) {
        if(s.length()==1)
        {
            return false;
        }
        StringBuffer sb=new StringBuffer(s);
        String str=new String(sb.reverse());
        for(int i=0;i<=s.length()-2;i++)
        {
            String st=s.substring(i,i+2);
            if(str.contains(st))
            {
                return true;
            }
        }
        
        return false;
    }
}
