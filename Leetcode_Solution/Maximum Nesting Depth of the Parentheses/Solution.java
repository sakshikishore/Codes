class Solution {
    public int maxDepth(String s) {
        Stack<Character> stck=new Stack<Character>();
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                stck.push('(');
            }
            else if(s.charAt(i)==')')
            {
                if(stck.size()>max)
                {
                    max=stck.size();
                }
                stck.pop();               
            }
        }
        
        return max;
        
    }
}
