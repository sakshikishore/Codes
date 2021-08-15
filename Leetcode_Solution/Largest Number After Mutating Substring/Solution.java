class Solution {
    public String maximumNumber(String num, int[] change) {
        String str="";
        int flag=0;
        for(int i=0;i<num.length();i++)
        {
            int p=num.charAt(i)-'0';
            if(Integer.parseInt(num.substring(i,i+1))<change[p])
            {
                flag=1;
                str=str+Integer.toString(change[p]);
                
            }
            else if(Integer.parseInt(num.substring(i,i+1))==change[p])
                    {
                        str=str+Integer.toString(change[p]);
                    }
            else
            {
                if(flag==0)
                {
                str=str+num.substring(i,i+1);
                }
                else
                {
                   str=str+num.substring(i);   
                    break;
                }
            
            }
        }
        return str;
    }
}
