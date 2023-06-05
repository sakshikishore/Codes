class Solution {
    public int minimizedStringLength(String s) {
        HashSet<Character> h=new HashSet<Character>();
        for(int i=0;i<s.length();i++)
        {
            if(!h.contains(s.charAt(i)))
            {
                h.add(s.charAt(i));
            }
        }
        
        return h.size();
    }
}
