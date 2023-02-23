class Solution {
    public int minMaxDifference(int num) {
        int max=0,flag=0;
        char val='1';
       
        String str=Integer.toString(num);
        for(int i=0;i<str.length();i++)
        {
            if(flag==0)
            {
                if(str.charAt(i)!='9')
                {
                    flag=1;
                    val=str.charAt(i);
                    max=max*10+9;
                }
                else
                {
                    max=max*10+Integer.parseInt(str.substring(i,i+1));
                }
                
            }
            else
            {
                if(str.charAt(i)==val)
                {
                    max=max*10+9;
                }
                else
                {
                    max=max*10+Integer.parseInt(str.substring(i,i+1));
                }
            }
        }
        flag=0;
        int min=0;
         for(int i=0;i<str.length();i++)
        {
            if(flag==0)
            {
                if(str.charAt(i)!='0')
                {
                    flag=1;
                    val=str.charAt(i);
                    min=min*10+0;
                }
                else
                {
                    min=min*10+Integer.parseInt(str.substring(i,i+1));
                }
                
            }
            else
            {
                if(str.charAt(i)==val)
                {
                    min=min*10+0;
                }
                else
                {
                    min=min*10+Integer.parseInt(str.substring(i,i+1));
                }
            }
        }
        
        
        return max-min;
    }
}
