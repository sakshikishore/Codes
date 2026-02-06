class Solution {
    public String reverseByType(String s) {
        Stack<Character> stck1=new Stack<Character>();
        Stack<Character> stck2=new Stack<Character>();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                stck1.add(s.charAt(i));
            }
            else
            {
                stck2.add(s.charAt(i));
            }
        }
        for(int i=0;i<s.length();i++)
        {
             if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
               sb.append(stck1.pop());
            }
            else
            {
                sb.append(stck2.pop());
            }
        }

        return sb.toString();
    }
}
