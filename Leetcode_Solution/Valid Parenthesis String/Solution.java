class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack1=new Stack<Integer>();
        Stack<Integer> stack2=new Stack<Integer>();
        boolean result=true;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                stack1.push(i);
            }
           else if(s.charAt(i)=='*')
            {
                stack2.push(i);
            }
            else
            {
                if(!stack1.empty())
                {
                    stack1.pop();
                }
                else
                {
                    if(!stack2.empty())
                    {
                        stack2.pop();
                        
                    }
                    else
                    {
                        result=false;
                        break;
                    }
                }
            }
        }
        while(!stack1.empty())
        {
            int p=stack1.pop();
            if(!stack2.empty())
            {
            int q=stack2.pop();
            if(q<p)
            {
                result=false;
                break;
            }
            }
            else
            {
                result=false;
                break;
            }
        }
        
        return result;
        
    }
}
