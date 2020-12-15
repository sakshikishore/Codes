class Solution {
    public int minPartitions(String n) {
        int result=0;
        for(int i=0;i<n.length();i++)
        {
            if((n.charAt(i)-'0')>result)
            {
                result=n.charAt(i)-'0';
            }
        }
        
        return result;
    }
}
