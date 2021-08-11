class Solution {
    public int minSwaps(String s) {
        Stack<Character> stck=new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='[')
            {
                stck.push('[');
            }
            else
            {
                if(!stck.empty())
                {
                    stck.pop();
                }
            }
        }
        double p= stck.size();
        return (int)Math.ceil(p/2.0);
        
    }
}
