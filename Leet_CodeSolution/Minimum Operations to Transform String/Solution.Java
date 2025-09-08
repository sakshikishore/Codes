class Solution {
    public int minOperations(String s) {
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            int x=s.charAt(i)-'a';
            if(x!=0)
            {
            result=Math.max(26-x,result);
            }
        }

        return result;
    }
}
