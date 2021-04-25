class Solution {
    public int longestBeautifulSubstring(String word) {
        int count=0;
        int p=0;
        int max=0;
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)=='a')
            {
                if(p==0 || p==1)
                {
                    p=1;
                    count++;
                }
                else
                {
                    if(p==5 && count>max)
                    {
                        max=count;
                    }
                    count=1;
                    p=1;
                }
                
            }
                
            else if(word.charAt(i)=='e')
            {
                 if(p==1 || p==2)
                {
                    p=2;
                    count++;
                }
                else
                {
                    if(p==5 && count>max)
                    {
                        max=count;
                    }
                    count=0;
                    p=0;
                }
            }
             else if(word.charAt(i)=='i')
            {
                
                if(p==2 || p==3)
                {
                    p=3;
                    count++;
                }
                else
                {
                    if(p==5 && count>max)
                    {
                        max=count;
                    }
                    count=0;
                    p=0;
                }
            }
             else if(word.charAt(i)=='o')
            {
                
                if(p==3 || p==4)
                {
                    p=4;
                    count++;
                }
                else
                {
                    if(p==5 && count>max)
                    {
                        max=count;
                    }
                    count=0;
                    p=0;
                }
            }
            else 
            {
                
                 if(p==4 || p==5)
                {
                    p=5;
                    count++;
                }
                else
                {
                    if(p==5 && count>max)
                    {
                        max=count;
                    }
                    count=0;
                    p=0;
                }
            }
        }  
        if(p==5 && count>max)
        {
            max=count;
        }
        return max;
        
    }
}
