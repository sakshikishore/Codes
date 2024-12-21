class Solution {
    public String rankTeams(String[] votes) {
        if(votes.length==1)
        {
            return votes[0];
        }
        int c[][]=new int[votes[0].length()][26];
        for(int i=0;i<votes.length;i++)
        {
            for(int j=0;j<votes[i].length();j++)
            {
                c[j][votes[i].charAt(j)-'A']++;
            }
        }
        char result[]=new char[votes[0].length()];
         HashSet<Integer> hset=new HashSet<Integer>();
         for(int t=0;t<votes[0].length();t++)
         {
            int flag=0;
            for(int i=0;i<votes[0].length();i++)
            {
                HashSet<Integer> hset1=new HashSet<Integer>();
                int max=0;
                for(int j=0;j<26;j++)
                {
                    if(!hset.contains(j))
                    {
                        if(c[i][j]>max)
                        {
                            max=c[i][j];
                        }
                    }
                }
                int ans=-1;
        
                for(int j=0;j<26;j++)
                {
                    if(!hset.contains(j))
                    {
                        if(c[i][j]==max)
                        {
                            hset1.add(j);
                            if(ans==-1)
                            {
                            ans=j;
                            }
                        }
                    }
                }
                if(hset1.size()==1)
                {
                    hset.add(ans);
                    flag=1;
                    result[t]=(char)(65+ans);
                }
                else
                { 
                    if(i+1==votes[0].length())
                    {
                        hset.add(ans);
                        flag=1;
                        result[t]=(char)(65+ans);
                        
                    }
                    else
                    {
                    for(int k=i+1;k<votes[0].length();k++)
                    {
                        max=0;
                        for(int j=0;j<26;j++)
                        {
                            if(!hset.contains(j) && hset1.contains(j))
                            {
                                if(c[k][j]>max)
                                {
                                    max=c[k][j];
                                }
                            }
                        }
                        HashSet<Integer> hset2=new HashSet<Integer>();
                        ans=-1;
                        for(int j=0;j<26;j++)
                        {
                            if(!hset.contains(j) && hset1.contains(j))
                            {
                                if(c[k][j]==max)
                                {
                                    hset2.add(j);
                                    if(ans==-1)
                                        {
                                        ans=j;
                                        }
                                }
                            }
                        }
                       

                        if(hset2.size()==1)
                        {
                            hset.add(ans);
                            result[t]=(char)(65+ans);
                            flag=1;
                            break;
                        }
                        else
                        {
                            if(k+1==votes[0].length())
                            {
                                hset.add(ans);
                                result[t]=(char)(65+ans);
                                flag=1;
                                break;
                            }
                            else
                            {
                            hset1=hset2;
                            }
                        }
                    }
                }
                }

                if(flag==1)
                {
                    break;
                }
            }
           
         }

        return new String(result);


    }
}
