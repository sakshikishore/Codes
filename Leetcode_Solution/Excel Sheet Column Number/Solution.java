class Solution {
    public int titleToNumber(String columnTitle) {
        int p=0;
        int result=0;
        for(int i=columnTitle.length()-1;i>=0;i--)
        {
            result=result+(int)Math.pow(26,p)*((columnTitle.charAt(i)-'A')+1);
            p++;
        }
        
        return result;
        
    }
}
