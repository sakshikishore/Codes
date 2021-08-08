class Solution {
    public String makeFancyString(String s) {
        StringBuffer sb=new StringBuffer();
        sb.append(s.substring(0,1));
        int count=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)!=s.charAt(i-1))
            {
                count=1;
                sb.append(s.substring(i,i+1));
            }
            else
            {
                count++;
                if(count<3)
                {
                    sb.append(s.substring(i,i+1));
                }
            }
        }
        
        return sb.toString();
        
    }
}
