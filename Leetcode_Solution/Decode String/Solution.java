class Solution {
    public String decodeString(String s) {
        Stack<String> stck=new Stack<String>();
        String result="";
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)==']')
            {
                stck.push("]");
            }
            else if(s.charAt(i)=='[')
            {
                continue;
            }
            else if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                stck.push(s.substring(i,i+1));
            }
            else 
            {
                int j=i;
                int p=0;
                String ptr="";
                while(j>=0 && s.charAt(j)>='0' && s.charAt(j)<='9')
                {
                  ptr=s.substring(j,j+1)+ptr;
                  j--;
                }
                p=Integer.parseInt(ptr);
                i=j+1;
                String str="";
                result="";
                while(!stck.empty() && !stck.peek().equals("]"))
                {
                    str=str+stck.pop();
                }
                stck.pop();
                for(int k=0;k<p;k++)
                {
                   result=result+str;
                }
                stck.push(result);
            }
        }
        
        result="";
        while(!stck.empty())
        {
            result+=stck.pop();
        }
               
        
        return result;      
        
    }
}
