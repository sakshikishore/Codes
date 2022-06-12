class Solution {
    public boolean strongPasswordCheckerII(String password) {
        boolean result=false;
        int flag=0;
        int ch[]=new int[4];
        if(password.length()>=8)
        {
            for(int i=0;i<password.length();i++)
            {
                if(i==0)
                {
                    if(password.charAt(i)>='a' && password.charAt(i)<='z')
                    {
                       ch[0]++;
                    }
                    else if(password.charAt(i)>='A' && password.charAt(i)<='Z')
                    {
                        ch[1]++;
                    }
                    else if(password.charAt(i)=='-' || password.substring(i,i+1).matches("[!@#$%^&*()+]"))
                    {
                        ch[3]++;
                    }
                    else if(password.charAt(i)>='0' && password.charAt(i)<='9')
                    {
                        ch[2]++;
                    }
                }
                else
                {
                    if(password.charAt(i)==password.charAt(i-1))
                    {
                        flag=1;
                        break;
                    }
                    else
                    {
                         if(password.charAt(i)>='a' && password.charAt(i)<='z')
                    {
                       ch[0]++;
                    }
                    else if(password.charAt(i)>='A' && password.charAt(i)<='Z')
                    {
                        ch[1]++;
                    }
                    else if(password.substring(i,i+1).matches("[!@#$%^&*()-+]"))
                    {
                        ch[3]++;
                    }
                    else if(password.charAt(i)>='0' && password.charAt(i)<='9')
                    {
                        ch[2]++;
                    }
                    }
                }
            }
        }
        if(flag==0)
        {
            if(ch[0]>0 && ch[1]>0 && ch[2]>0 && ch[3]>0)
            {
                result=true;
            }
        }
        
        return result;
        
    }
}
