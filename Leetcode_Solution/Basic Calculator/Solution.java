class Solution {
    public int calculate(String s) {
    Stack<String> stck=new Stack<String>();
    s=s.trim();
    for(int i=s.length()-1;i>=0;i--)
    {
        if(s.substring(i,i+1).equals(" "))
        {
            continue;
        }
        else if(s.charAt(i)=='+' || s.charAt(i)=='-')
        {
            stck.push(s.substring(i,i+1));
        }
        else if(s.charAt(i)==')')
        {
            stck.push(")");
        }
       else if(s.charAt(i)=='(')
        {
            int prev=0;  
            String operator="";
            while(!stck.peek().equals(")"))
            {
                String p=stck.pop();
                if(p.equals("+") || p.equals("-"))
                {
                    operator=p;
                }
                else
                {
                    int x=Integer.parseInt(p);
                    if(operator.equals("+"))
                    {
                        prev=x+prev;
                    }
                    else if(operator.equals("-"))
                    {
                        prev=prev-x;
                    }
                    else
                    {
                        prev=x;
                    }
                }
            }
           
            stck.pop();
            stck.push(Integer.toString(prev));
        }
        else
        {
            int j=i;
            String str="";
            while(j>=0 && s.charAt(j)>='0' && s.charAt(j)<='9')
            {
                str=s.substring(j,j+1)+str;
                j--;
            }
            i=j+1;
            stck.push(str);
        }
    }
    int result=0;
    String sign="";
    while(!stck.empty())
    {
        String top=stck.pop();
        if(top.equals("+") || top.equals("-"))
        {
            sign=top;
        }
        else
        {
            if(sign.equals("+"))
            {
                result=result+Integer.parseInt(top);
            }
            else if(sign.equals("-"))
            {
                result=result-Integer.parseInt(top);
            }
            else
            {
                result=Integer.parseInt(top);
            }
        }
    }
        
        return result;
        
        
    }
}
