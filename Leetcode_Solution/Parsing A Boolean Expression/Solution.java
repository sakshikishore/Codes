class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stck=new Stack<Character>();
        for(int i=expression.length()-1;i>=0;i--)
        {
            if(expression.charAt(i)==')')
            {
                stck.push(')');
            }
            else if(expression.charAt(i)==',')
            {
                continue;
            }
            else if(expression.charAt(i)=='t' || expression.charAt(i)=='f')
            {
                stck.push(expression.charAt(i));
            }
            else if(expression.charAt(i)=='(')
            {
                char a=expression.charAt(i-1);
                if(a=='|')
                {
                    char result='f';
                    while(stck.peek()!=')')
                    {
                        if(stck.pop()=='t')
                        {
                            result='t';
                        }
                    }
                    stck.pop();
                    stck.push(result);
                    i=i-1;
                }
                else if(a=='!')
                {
                    if(stck.pop()=='t')
                    {
                        stck.pop();
                        stck.push('f');
                    }
                    else
                    {
                        stck.pop();
                        stck.push('t');
                    }
                    i=i-1;
                }
                else
                {
                    char result='t';
                    while(stck.peek()!=')')
                    {
                        if(stck.pop()=='f')
                        {
                            result='f';
                        }
                    }
                    stck.pop();
                    stck.push(result);
                    i=i-1;
                }
                
            }
        }
        
        if(stck.pop()=='t')
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}
