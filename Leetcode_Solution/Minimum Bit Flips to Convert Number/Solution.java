class Solution {
    public int minBitFlips(int start, int goal) {
        int count=0;
        if(start!=goal)
        {
          String target=Integer.toBinaryString(goal);
          String source=Integer.toBinaryString(start);
        
        
        int i=source.length()-1;
        int j=target.length()-1;
        while(i>=0 && j>=0)
        {
            if(source.charAt(i)!=target.charAt(j))
            {
                count++;
            }
            i--;
            j--;
        }
        if(i==-1)
        {
            while(j>=0)
            {
                if(target.charAt(j)=='1')
                {
                    count++;
                }
                j--;
            }
        }
        else if(j==-1)
        {
            while(i>=0)
            {
                if(source.charAt(i)=='1')
                {
                    count++;
                }
                i--;
            }
        }
        }
        
        return count;
    }
}
