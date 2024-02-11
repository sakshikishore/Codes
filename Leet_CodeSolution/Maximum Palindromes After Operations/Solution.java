class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int count=0;
        int ch[]=new int[26];
        int p[]=new int[26];
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words[i].length();j++)
            {
                ch[words[i].charAt(j)-'a']++;
                p[words[i].charAt(j)-'a']++;
            }
        }
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(words[i].length()>words[j].length())
                {
                    String temp=words[i];
                    words[i]=words[j];
                    words[j]=temp;
                }
            }
        }
    
        for(int i=0;i<words.length;i++)
        {
            int len=words[i].length();
            int flag=1;
            if(len%2==0)
            { 
                for(int j=0;j<26;j++)
                {
                    if(ch[j]>=len)
                    {
                        ch[j]=ch[j]-len;
                        count++;
                        flag=0;
                        break;
                    }
                    else 
                    {
                        if(ch[j]%2==0 && ch[j]!=0)
                        {
                            len=len-ch[j];
                            ch[j]=0;
                        }
                        else
                        {
                          if(ch[j]>1)
                          {
                              
                              len=len-ch[j]+1;
                              ch[j]=1;
                          }
                        }
                    }
                }
                 if(flag==1)
                {
                    ch=p;
                }
                else
                {
                    p=ch;
                }
            }
            else
            {
                int index=-1;
                for(int j=0;j<26;j++)
                {
                    if(ch[j]%2!=0)
                    {
                        index=j;
                        len=len-1;
                        ch[j]--;
                        break;
                    }
                }
                for(int j=0;j<26;j++)
                {
                    if(ch[j]>=len)
                    {
                        ch[j]=ch[j]-len;
                        count++;
                        flag=0;
                        break;
                    }
                    else 
                    {
                         if(ch[j]%2==0 && ch[j]!=0)
                        {
                            len=len-ch[j];
                            ch[j]=0;
                        }
                        else
                        {
                          if(ch[j]>1)
                          {
                          len=len-ch[j]+1;
                          ch[j]=1;
                          }
                        }
                    }
                }
                
                if(flag==1)
                {
                    ch=p;
                }
                else
                {
                    p=ch;
                }
            }
        
        }
        
        return count;
    }
}
