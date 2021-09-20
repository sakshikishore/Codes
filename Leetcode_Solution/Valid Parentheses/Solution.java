class Solution {
    public boolean isValid(String s) {
        boolean result=true;
        Stack<Character> stck=new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
            {
                stck.push(s.charAt(i));
            }
            else
            {
                if(stck.empty())
                {
                    result=false;
                    break;
                }
                else
                {
                  if((stck.peek()=='(' && s.charAt(i)==')')||(stck.peek()=='{' && s.charAt(i)=='}')||(stck.peek()=='[' && s.charAt(i)==']'))
                  {
                      stck.pop();
                  }
                  else
                  {
                      result=false;
                      break;
                  }
                }
            }
        }
        
        if(!stck.empty())
        {
            result=false;
        }
        
        return result;
        
    }
}
