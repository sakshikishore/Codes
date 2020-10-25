class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max=0;
        char result='a';
        for(int i=0;i<keysPressed.length();i++)
        {
            if(i==0)
            {
                if(releaseTimes[0]>max)
                {
                    max=releaseTimes[0];
                    result=keysPressed.charAt(i);
                }
            }
            else
            {
                if(releaseTimes[i]-releaseTimes[i-1]>max)
                {
                    max=releaseTimes[i]-releaseTimes[i-1];
                    result=keysPressed.charAt(i);
                }
                else if(releaseTimes[i]-releaseTimes[i-1]==max)
                {
                    if(keysPressed.charAt(i)>result)
                    {
                        result=keysPressed.charAt(i);
                    }
                }
            }
        }
        
        return result;
        
    }
}
