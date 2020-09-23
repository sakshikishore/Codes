class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stck=new Stack<Integer>();
        int i=0;
        while(i<s.length())
        {
            if(s.charAt(i)=='(')
            {
                stck.push(i);
            }
            else if(s.charAt(i)==')')
            {
                int p=stck.pop();
                String str=s.substring(p+1,i);
                StringBuffer sb=new StringBuffer(str);
                s=s.substring(0,p)+sb.reverse().toString()+s.substring(i+1);
                i=i-2;
            }
            
            i++;
            
        }
        
        return s;
        
    }
}
