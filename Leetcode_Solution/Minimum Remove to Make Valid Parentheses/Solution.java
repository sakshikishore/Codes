class Solution {
    public String minRemoveToMakeValid(String s) {
        String str="";
        int c=0;
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(i-c);
            }
            else if(s.charAt(i)==')')
            {
                if(st.size()>0)
                {
                    int p=st.pop()-st.size();
                    str=str.substring(0,p)+"("+str.substring(p)+")";
                }
                else
                {
                    c++;
                }
            }
            else
            {
                str=str+s.substring(i,i+1);
            }
        }
        
        return str;
        
    }
}
