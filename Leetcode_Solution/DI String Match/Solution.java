class Solution {
    public int[] diStringMatch(String s) {
       int res[]=new int[s.length()+1];
        if(s.charAt(0)=='I')
        {
            res[0]=0;
            res[1]=1;
        }
        else
        {
            res[0]=1;
            res[1]=0;
        }
        int p=2;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)=='I')
            {
                res[i+1]=p;
            }
            else
            {
                int temp=res[i];
                res[i]=p;
                res[i+1]=temp;
                int j=i-1;
                while(j>=0)
                {
                    if(s.charAt(j)=='D')
                    {
                        if(res[j]>res[j+1])
                        {
                            break;
                        }
                        else
                        {
                            temp=res[j];
                            res[j]=res[j+1];
                            res[j+1]=temp;
                        }
                    }
                    else
                    {
                        if(res[j]<res[j+1])
                        {
                            break;
                        }
                        else
                        {
                            temp=res[j];
                            res[j]=res[j+1];
                            res[j+1]=j;
                        }
                    }
                    j--;
                }
            }
            p++;
        }
        return res;
    }
}
