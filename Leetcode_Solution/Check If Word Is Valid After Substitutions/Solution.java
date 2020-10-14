class Solution {
    public boolean isValid(String s) {
        Stack<Character> stck=new Stack<Character>();
        boolean result=false;
        for(int i=0;i<s.length();i++)
        {
            if(stck.empty())
            {
                stck.push(s.charAt(i));
            }
            else
            {
                if(s.charAt(i)=='c')
                {
                    if(stck.size()>1 && stck.peek()=='b')
                    {
                        stck.pop();
                        if(stck.peek()=='a')
                        {
                            stck.pop();
                        }
                        else
                        {
                            stck.push('b');
                            stck.push('c');
                        }
                    }
                    else
                    {
                        stck.push('c');
                    }
                }
                else
                {
                    stck.push(s.charAt(i));
                }
                    
            }
        }
        
        if(stck.empty())
        {
            result=true;
        }
        
        return result;
    }
}
