class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> stck=new Stack<String>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                if(stck.empty())
                {
                    stck.push("(");
                }
                else
                {
                    if(stck.peek().equals("("))
                    {
                        stck.push("2 *");
                        stck.push("(");
                    }
                    else
                    {
                        stck.push("(");
                    }
                }
            }
            else
            {
                if(stck.peek()=="(")
                {
                    stck.pop();
                    stck.push("1");
                }
                else
                {
                    int sum=0;
                    while(stck.peek()!="(")
                    {
                       if(stck.peek().contains("*"))
                       {
                           sum=sum*2;
                           stck.pop();
                       }
                       else
                        {
                            sum=sum+Integer.parseInt(stck.peek());
                            stck.pop();
                        }
                    }
                    stck.pop();
                    stck.push(Integer.toString(sum));
                }
            }
        }
        int result=0;
        if(stck.size()==1)
        {
            result=Integer.parseInt(stck.pop());
        }
        else
        {
            while(!stck.empty())
            {
                result+=Integer.parseInt(stck.pop());
            }
        }
        
        return result;
    }
}
