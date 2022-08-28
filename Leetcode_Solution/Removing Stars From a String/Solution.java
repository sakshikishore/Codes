class Solution {
    public String removeStars(String s) {
        Stack<Character> stck=new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                stck.push(s.charAt(i));
            }
            else
            {
                stck.pop();
            }
        }
        char c[]=new char[stck.size()];
        int i=c.length-1;
        while(!stck.empty())
        {
            c[i]=stck.pop();
            i--;
        }
        
        return new String(c);
    }
}
