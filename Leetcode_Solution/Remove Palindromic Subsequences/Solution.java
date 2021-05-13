class Solution {
    public int removePalindromeSub(String s) {
        // if String is not palindrome then we can take all 'a' in 1 step and all 'b' in 2nd step. so final result will be 2 in this case
        int result=2;
        StringBuffer sb=new StringBuffer(s);
        String p=new String(sb.reverse());
        if(p.equals(s))
        {
            result=1;
        }
        return result;
    }
}
