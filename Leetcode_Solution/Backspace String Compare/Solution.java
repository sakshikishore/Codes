class Solution {
    public boolean backspaceCompare(String s, String t) {
        boolean result=false;
        String s1="";
        String t1="";
        int i=s.length()-1;
        int count=0;
        while(i>=0)
        {
            if(s.charAt(i)!='#')
            {
                if(count==0)
                {
                s1=s.substring(i,i+1)+s1;
                }
                else
                {
                    count--;
                }
            }
            else
            {
                count++;
            }
            i--;
        }
        i=t.length()-1;
        count=0;
         while(i>=0)
        {
            if(t.charAt(i)!='#')
            {
                if(count==0)
                {
                t1=t.substring(i,i+1)+t1;
                }
                else
                {
                    count--;
                }
            }
            else
            {
                count++;
            }
            i--;
        }
        
        if(s1.equals(t1))
        {
            result=true;
        }
        
        return result;
    }
}
