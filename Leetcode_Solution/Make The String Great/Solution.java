class Solution {
    public String makeGood(String s) {
        StringBuffer sb=new StringBuffer("");
        Stack<Character> st=new  Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(st.empty())
            {
                st.push(c);
            }
            else
            {
                char top=st.peek();
                if(top==c)
                {
                    st.push(c);
                }
            else if(((c>='A' && c<='Z') && (top>='A' && top<='Z')) || ((c>='a' && c<='z') && (top>='a' && top<='z')))
                {
                        st.push(c);
                }
                else
                {
                    if(c>='A' && c<='Z')
                    {
                        if((c-'A')==(top-'a'))
                        {
                            st.pop();
                        }
                        else
                        {
                             st.push(c);
                        }
                    }
                    else
                    {
                        if((c-'a')==(top-'A'))
                        {
                            st.pop();
                        }
                        else
                        {
                             st.push(c);
                        }
                    }
                }
                
            }
        }
        while(!st.empty())
        {
            sb.append(Character.toString(st.pop()));
        }
        
        String str=new String(sb.reverse());
        return str;
        
    }
}
