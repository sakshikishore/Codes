class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        int p=(k*(k+1))/2;
        if(p<=n && n<=45)
        {
            if(k==9)
            {
                if(n==45)
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    for(int i=1;i<=9;i++)
                    {
                      l.add(i);
                    }
                    list.add(l);
                }
            }
            else if(k==8)
            {
                if(n<45)
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    for(int i=1;i<=9;i++)
                    {
                        if((45-i)==n)
                        {
                            for(int j=i+1;j<=9;j++)
                            {
                                l.add(j);
                            }
                            break;
                        }
                        else
                        {
                            l.add(i);
                        }
                    }
                    list.add(l);
                }
            }
            else if(k==7)
            {
                if(n<43)
                {
                   for(int i=1;i<=9;i++)
                   {
                       for(int j=i+1;j<=9;j++)
                       {
                           if(45-i-j==n)
                           {
                               ArrayList<Integer> l=new ArrayList<Integer>();
                               for(int m=1;m<=9;m++)
                               {
                                   if(m!=i && m!=j)
                                   {
                                       l.add(m);
                                   }
                               }
                               list.add(l);
                           }
                       }
                   }
                }
            }
            else if(k==2)
            {
                if(n<18)
                {
                     for(int i=1;i<=9;i++)
                     {
                         for(int j=i+1;j<=9;j++)
                         {
                             if((i+j)==n)
                             {
                                ArrayList<Integer> l=new ArrayList<Integer>();
                                 l.add(i);
                                 l.add(j);
                                 list.add(l);
                             }
                         }
                     }
                    
                }
            }
            else if(k==3)
            {
                if(n<25)
                {
                    for(int i=1;i<=9;i++)
                    {
                        for(int j=i+1;j<=9;j++)
                        {
                            for(int k1=j+1;k1<=9;k1++)
                            {
                                if(i+j+k1==n)
                                {
                                    ArrayList<Integer> l=new ArrayList<Integer>();
                                    l.add(i);
                                    l.add(j);
                                    l.add(k1);
                                    list.add(l);
                                }
                            }
                        }
                    }
                }
            }
            else if(k==4)
            {
                if(n<31)
                {
                     for(int i=1;i<=9;i++)
                    {
                        for(int j=i+1;j<=9;j++)
                        {
                            for(int k1=j+1;k1<=9;k1++)
                            {
                                for(int m=k1+1;m<=9;m++)
                                {
                                    if(i+j+k1+m==n)
                                    {
                                        ArrayList<Integer> l=new ArrayList<Integer>();
                                        l.add(i);
                                        l.add(j);
                                        l.add(k1);
                                        l.add(m);
                                        list.add(l);
                                }
                                }
                            }
                        }
                    }
                }
            }
            else if(k==5)
            {
                if(n<36)
                {
                     for(int i=1;i<=9;i++)
                    {
                        for(int j=i+1;j<=9;j++)
                        {
                            for(int k1=j+1;k1<=9;k1++)
                            {
                                for(int m=k1+1;m<=9;m++)
                                {
                                    for(int o=m+1;o<=9;o++)
                                    {
                                    if(i+j+k1+m+o==n)
                                    {
                                        ArrayList<Integer> l=new ArrayList<Integer>();
                                        l.add(i);
                                        l.add(j);
                                        l.add(k1);
                                        l.add(m);
                                        l.add(o);
                                        list.add(l);
                                    }
                                    }
                                }
                            }
                        }
                    }
                }
            }
             else if(k==6)
            {
                if(n<40)
                {
                     for(int i=1;i<=9;i++)
                    {
                        for(int j=i+1;j<=9;j++)
                        {
                            for(int k1=j+1;k1<=9;k1++)
                            {
                                for(int m=k1+1;m<=9;m++)
                                {
                                    for(int o=m+1;o<=9;o++)
                                    {
                                        for(int q=o+1;q<=9;q++)
                                        {
                                            if(i+j+k1+m+o+q==n)
                                            {
                                                
                                                ArrayList<Integer> l=new ArrayList<Integer>();
                                                l.add(i);
                                                l.add(j);
                                                l.add(k1);
                                                l.add(m);
                                                l.add(o);
                                                l.add(q);
                                                list.add(l);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}
