class Solution {
    public String removeOuterParentheses(String S) {
        String str="";
        Stack<Character> stck=new Stack<Character>();
        int count=0;
         for(int i=0;i<S.length();i++)
         {
            if(stck.empty())
            {
                if(S.charAt(i)=='(')
                {
                    stck.push('(');
                }
            }
            else if(S.charAt(i)=='(')
             { 
                str=str+S.substring(i,i+1);
                     count++;
                 
             }
             else
             {
                 if(count>0)
                 {
                      str=str+S.substring(i,i+1);
                      count=count-1;
                 }
                 else
                 {
                     stck.pop();
                 }
             }
             
         }
        
        return str;
    }
}
