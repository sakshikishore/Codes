class Solution {
    public boolean isItPossible(String word1, String word2) {
        int ch1[]=new int[26];
        int ch2[]=new int[26];
        int count1=0,count2=0;
        for(int i=0;i<word1.length();i++)
        {
            ch1[word1.charAt(i)-'a']++;
            if(ch1[word1.charAt(i)-'a']==1)
            {
                count1++;
            }
        }
        
        for(int i=0;i<word2.length();i++)
        {
            ch2[word2.charAt(i)-'a']++;
            if(ch2[word2.charAt(i)-'a']==1)
            {
                count2++;
            }
        }
        int flag=0;
        for(int i=0;i<26;i++)
        {
            if(ch1[i]!=0 && ch2[i]!=0)
            {
                continue;
            }
            else if(ch1[i]==0 && ch2[i]==0)
            {
                continue;
            }
            else
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            return true;
        }
        for(int i=0;i<26;i++)
        {
            if(ch1[i]>0)
            {
                for(int j=0;j<26;j++)
                {
                     if(ch2[j]>0 && j!=i)
                     {
                         if(ch2[i]==0)
                         {
                             if(ch2[j]>1)
                             {
                                int x=count2+1;
                                int y=count1;
                                if(ch1[i]>1)
                                {
                                    if(ch1[j]==0)
                                    {
                                        y=y+1;
                                        if(x==y)
                                        {
                                            return true;
                                        }
                                    }
                                    else
                                    {
                                    
                                        if(x==y)
                                        {
                                            return true;
                                        }
                                    }
                                        
                                }
                                else
                                {
                                    if(ch1[j]>0)
                                    {
                                        y=y-1;
                                        if(x==y)
                                        {
                                            return true;
                                        }
                                    }
                                    else
                                    {
                                        if(x==y)
                                        {
                                            return true;
                                        }
                                    }
                                }
                             }
                             else
                             {
                                 int x=count2;
                                 int y=count1;
                                if(ch1[i]>1)
                                {
                                    if(ch1[j]==0)
                                    {
                                        y=y+1;
                                        if(x==y)
                                        {
                                            return true;
                                        }
                                    }
                                    else
                                    {
                                    
                                        if(x==y)
                                        {
                                            return true;
                                        }
                                    }
                                        
                                }
                                else
                                {
                                    if(ch1[j]>0)
                                    {
                                        y=count1-1;
                                        if(x==y)
                                        {
                                            return true;
                                        }
                                    }
                                    else
                                    {
                                        if(x==y)
                                        {
                                            return true;
                                        }
                                    }
                                }
                             }
                         }
                         else
                         {
                             int x=count2;
                             int y=count1;
                             if(ch2[j]==1)
                             {
                                 x=x-1;
                             }
                             if(ch1[i]==1)
                             {
                                 if(ch1[j]>0)
                                 {
                                     y=y-1;
                                     if(x==y)
                                     {
                                         return true;
                                     }
                                 }
                                 else
                                 {
                                     if(x==y)
                                     {
                                         return true;
                                     }
                                 }
                             }
                             else
                             {
                                 if(ch1[j]>0)
                                 {
                                    
                                     if(x==y)
                                     {
                                         return true;
                                     }
                                 }
                                 else
                                 {
                                     y=y+1;
                                     if(x==y)
                                     {
                                         return true;
                                     }
                                 }
                             }
                             
                         }
                     }
                }
            }
        }
        
        return false;
        
    }
}
