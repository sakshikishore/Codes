class Solution {
    public int minimumOperations(String num) {
        int index=0;
        int flag=0,ans=Integer.MAX_VALUE;
        for(int i=num.length()-1;i>=0;i--)
        {
            if(num.charAt(i)=='5')
            {
                index=i;
                flag=1;
            }
            else if(flag==1 && num.charAt(i)=='2')
            {
                ans=num.length()-index-1+(index-i-1);
                break;
            }
        }
         index=-1;
        for(int i=num.length()-1;i>=0;i--)
        {
            if(index==-1 && num.charAt(i)=='0')
            {
                index=i;
                flag=1;
            }
            else if(index!=-1 && num.charAt(i)=='0')
            {
                int p=num.length()-index-1+(index-i-1);
                if(p<ans)
                {
                    ans=p;
                }
                break;
            }
        }
        index=-1;
        for(int i=num.length()-1;i>=0;i--)
        {
            if(index==-1 && num.charAt(i)=='0')
            {
                index=i;
                flag=1;
            }
            else if(index!=-1 && num.charAt(i)=='5')
            {
                int p=num.length()-index-1+(index-i-1);
                if(p<ans)
                {
                    ans=p;
                }
                break;
            }
        }
         index=-1;
        for(int i=num.length()-1;i>=0;i--)
        {
            if(index==-1 && num.charAt(i)=='5')
            {
                index=i;
                flag=1;
            }
            else if(index!=-1 && num.charAt(i)=='7')
            {
                int p=num.length()-index-1+(index-i-1);
                if(p<ans)
                {
                    ans=p;
                }
                break;
            }
        }
        if(ans==Integer.MAX_VALUE)
        {
            if(num.contains("0"))
            {
                return num.length()-1;
            }
            return num.length();
        }
        
        return ans;
    }
}
