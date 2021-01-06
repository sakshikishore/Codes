class Solution {
    public int totalFruit(int[] tree) {
        int max=0;
        int a=-1,b=-1;
        int last=0,p=0,q=0,count=0;
        for(int i=0;i<tree.length;i++)
        {
            if(a==-1)
            {
                a=tree[i];
                count++;
                last=a;
                p++;
                q=0;
                
            }
            else
            {
                if(tree[i]!=a)
                {
                    if(b==-1)
                    {
                        b=tree[i];
                        last=b;
                        count++;
                        p=0;
                        q++;
                    }
                    else if(tree[i]==b)
                    {
                        last=b;
                        count++;
                        p=0;
                        q++;
                    }
                    else
                    {
                        if(count>max)
                        {
                            max=count;
                            
                        }
                        count=1;
                        if(last==a)
                        {
                            count=count+p;
                        }
                        else
                        {
                            count=count+q;
                        }
                        a=last;
                        b=tree[i];
                        last=b;
                        p=0;
                        q=1;
                    }
                }
                else
                {
                    last=a;
                    p++;
                    q=0;
                    count++;
                }
            }
        }
        if(count>max)
        {
            max=count;
        }
        
        return max;
        
    }
}
