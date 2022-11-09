class Solution {
    public int longestWPI(int[] hours) {
        int max=0;
        for(int i=0;i<hours.length;i++)
        {
            if(max>hours.length-i)
            {
                break;
            }
            int tiring_days=0,non_tiring_days=0;
            for(int j=i;j<hours.length;j++)
            {
                if(hours[j]>8)
                {
                    tiring_days++;
                }
                else
                {
                    non_tiring_days++;
                }
                
                if(tiring_days!=0 && non_tiring_days!=0 && tiring_days>non_tiring_days && (tiring_days+non_tiring_days)>max)
                {
                    max=tiring_days+non_tiring_days;
                }
                else if(non_tiring_days==0 && tiring_days>max)
                {
                    max=tiring_days;
                }
            
         }
    }
        
        return max;
    }
}
