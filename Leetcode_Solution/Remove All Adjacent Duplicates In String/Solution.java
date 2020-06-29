class Solution {
    public String removeDuplicates(String S) {
        Stack<String> st=new Stack<String>();
        for(int i=0;i<S.length();i++)
        {
            if(!st.empty() && S.substring(i,i+1).equals(st.peek()))
            {
                st.pop();
            }
            else
            {
                st.push(S.substring(i,i+1));
            }
        }
        
        String str="";
        while(!st.empty())
        {
            str=st.pop()+str;
        }
        
        return str;
        
    }
}
