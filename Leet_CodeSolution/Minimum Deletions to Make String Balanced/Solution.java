class Solution {
    public int minimumDeletions(String s) {
        int b=0;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
            {
                if(b>0)
                {
                    count++;
                    b--;
                }
            }
            else
            {
                b++;
            }
        }

        return count;
    }
}
