class Solution {
    public int minInsertions(String s) {
    Stack<Character> stck=new Stack<Character>();
    int result=0;
    int i=0;
    while(i<s.length())
    {
        if(s.charAt(i)=='(')
        {
            stck.push('(');
            i++;
        }
        else
        {
            if(stck.empty())
            {
                if(i+1<s.length())
                {
                    if(s.charAt(i+1)==')')
                    {
                        result++;
                        i=i+2;
                    }
                    else
                    {
                        result=result+2;
                         i++;
                   
                    }
                }
                else
                {
                    result=result+2;
                    i++;
                }
            }
            else
            {
                stck.pop();
                if(i+1<s.length())
                {
                    if(s.charAt(i+1)==')')
                    {
                        
                        i=i+2;
                    }
                    else
                    {
                        result=result+1;
                         i++;
                   
                    }
                }
                else
                {
                    result=result+1;
                    i++;
                }
                
            }
        }
    }
        
        while(!stck.empty())
        {
            result=result+2;
            stck.pop();
        }
        
        return result;
        
    }
}
