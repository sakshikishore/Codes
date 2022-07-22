class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stck=new Stack<Integer>();
        stck.push(-1);
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                stck.push(i);
            }
            else
            {
                stck.pop();
                if(stck.empty())
                {
                    stck.push(i);
                }
                else
                {
                    int l=i-stck.peek();
                    if(l>max)
                    {
                        max=l;
                    }
                }
            }
        }
        
        return max;
    }
}
