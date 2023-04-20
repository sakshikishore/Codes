class Solution {
    HashSet<String> h=new HashSet<String>();
    ArrayList<String> l=new ArrayList<String>();
    HashSet<String> visited=new HashSet<String>();
    public int getCount(StringBuffer s)
    {
        Stack<Character> stck=new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                stck.push('(');
            }
            else if(s.charAt(i)==')')
            {
                if(stck.empty())
                {
                    stck.push(')');
                }
                else if(stck.peek()=='(')
                {
                    stck.pop();
                }
                else
                {
                    stck.push(')');
                }
            }
        }

        return stck.size();
    }
    public void getSolution(int count,StringBuffer s)
    {
        if(count==0)
        {
            int c=getCount(s);
            if(c==0)
            {
                if(!h.contains(new String(s)))
                {
                    h.add(new String(s));
                    l.add(new String(s));
                }
            }
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            StringBuffer str=new StringBuffer("");
            str.append(s.substring(0,i));
            str.append(s.substring(i+1));
            if(!visited.contains(new String(str)))
            {
                visited.add(new String(str));
               getSolution(count-1,str);
            }
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        StringBuffer st=new StringBuffer(s);
        int count=getCount(st);
        getSolution(count,st);

        return l;
    }
}
