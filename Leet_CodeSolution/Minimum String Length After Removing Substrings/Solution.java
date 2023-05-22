class Solution {
    public int minLength(String s) {
        Stack<Character> stck=new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(stck.size()==0)
            {
              stck.push(s.charAt(i));
            }
            else
            {
                int x=stck.peek();
                if(x=='A' && s.charAt(i)=='B')
                {
                    stck.pop();
                }
                else if(x=='C' && s.charAt(i)=='D')
                {
                    stck.pop();
                }
                else
                {
                    stck.push(s.charAt(i));
                }
            }
        }

        return stck.size();
    }
}
