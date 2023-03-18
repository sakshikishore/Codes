class Solution {
    public boolean isNumber(String s) {
        int flag=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='0' && s.charAt(i)<='9')
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            return false;
        }
        else
        {
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)>='a' && s.charAt(i)<='z' && s.charAt(i)!='e')
                {
                    return false;
                }
                else if(s.charAt(i)>='A' && s.charAt(i)<='Z' && s.charAt(i)!='E')
                {
                    return false;
                }
            }
        }
        try
        {
            Double x=Double.parseDouble(s);
            
        }
        catch(Exception e)
        {
            return false;
        }

        return true;
    }
}
