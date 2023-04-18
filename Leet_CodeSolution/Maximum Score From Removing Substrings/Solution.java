class Solution {
    public int maximumGain(String s, int x, int y) {
        int result=0;
        if(x>y)
        {
            Stack<Character> stck=new Stack<Character>();
            for(int i=0;i<s.length();i++)
            {
                if(stck.empty())
                {
                    stck.push(s.charAt(i));
                }
                else
                {
                    if(stck.peek()=='a' && s.charAt(i)=='b')
                    {
                        result+=x;
                        stck.pop();
                    }
                    else
                    {
                        stck.push(s.charAt(i));
                    }
                }
            }
            Stack<Character> stck1=new Stack<Character>();
            while(stck.size()>0)
            {
                if(stck1.size()==0)
                {
                    stck1.push(stck.pop());
                }
                else
                {
                    if(stck1.peek()=='a' && stck.peek()=='b')
                    {
                        result+=y;
                        stck1.pop();
                        stck.pop();
                    }
                    else
                    {
                        stck1.push(stck.pop());
                    }
                }
            }
            
        }
        else
        {
            Stack<Character> stck=new Stack<Character>();
            for(int i=0;i<s.length();i++)
            {
                if(stck.empty())
                {
                    stck.push(s.charAt(i));
                }
                else
                {
                    if(stck.peek()=='b' && s.charAt(i)=='a')
                    {
                        result+=y;
                        stck.pop();
                    }
                    else
                    {
                        stck.push(s.charAt(i));
                    }
                }
            }
            Stack<Character> stck1=new Stack<Character>();
            while(stck.size()>0)
            {
                if(stck1.size()==0)
                {
                    stck1.push(stck.pop());
                }
                else
                {
                    if(stck1.peek()=='b' && stck.peek()=='a')
                    {
                        result+=x;
                        stck1.pop();
                        stck.pop();
                    }
                    else
                    {
                        stck1.push(stck.pop());
                    }
                }
            }
            

        }

        return result;

    }
}
