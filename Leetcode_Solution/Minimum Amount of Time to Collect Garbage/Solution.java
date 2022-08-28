class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ch[]=new int[3];
        int result=0;
        for(int i=0;i<garbage.length;i++)
        {
            for(int j=0;j<garbage[i].length();j++)
            {
                if(garbage[i].charAt(j)=='M')
                {
                    ch[0]++;
                }
                else if(garbage[i].charAt(j)=='P')
                {
                    ch[1]++;
                }
                else
                {
                    ch[2]++;
                }
            }
        }
        for(int i=0;i<3;i++)
        {
            int sum=0;
            char c='G';
            if(i==0)
            {
                c='M';
            }
            else if(i==1)
            {
                c='P';
            }
            for(int j=0;j<garbage.length;j++)
            {
                if(j!=0)
                {
                    sum+=travel[j-1];
                }
                    for(int k=0;k<garbage[j].length();k++)
                    {
                        if(garbage[j].charAt(k)==c)
                        {
                            ch[i]--;
                            sum++;
                        }
                    }
                if(ch[i]==0)
                {
                    result+=sum;
                    break;
                }
            }
        }
        
        return result;
           
    }
}
