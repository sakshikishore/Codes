class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        long result[]=new long[5];
        long p=n-1;
        long total=(p)*(m-1);
        HashSet<String> hset=new HashSet<String>();
        HashSet<String> h=new HashSet<String>();
        long a=0;
        for(int i=0;i<coordinates.length;i++)
        {
            String str=Integer.toString(coordinates[i][0])+" "+Integer.toString(coordinates[i][1]);
            hset.add(str);
        }
         for(int i=0;i<coordinates.length;i++)
        {
            int x=coordinates[i][0];
            int y=coordinates[i][1];
            String str1=Integer.toString(x)+" "+Integer.toString(y);
            //x, y at 0th position
            if(x<m-1 && y<n-1)
            {
                String str2=Integer.toString(x)+" "+Integer.toString(y+1);
                String str3=Integer.toString(x+1)+" "+Integer.toString(y);
                String str4=Integer.toString(x+1)+" "+Integer.toString(y+1);
                String s=str1+"|"+str2+"|"+str3+"|"+str4;
               if(!h.contains(s))
                 {
                    int count=1;
                    if(hset.contains(str2))
                    {
                        count++;
                    }
                    if(hset.contains(str3))
                    {
                        count++;
                    }
                     if(hset.contains(str4))
                    {
                        count++;
                    }
                    result[count]++;
                    a++;
                    h.add(s);
                 }

            }
            // x,y at 1st position
            if(y-1>=0 && x+1<m)
            {
                 String str2=Integer.toString(x)+" "+Integer.toString(y-1);
                 String str3=Integer.toString(x+1)+" "+Integer.toString(y-1);
                 String str4=Integer.toString(x+1)+" "+Integer.toString(y);
                 String s=str2+"|"+str1+"|"+str3+"|"+str4;
                 if(!h.contains(s))
                 {
                    int count=1;
                    if(hset.contains(str2))
                    {
                        count++;
                    }
                    if(hset.contains(str3))
                    {
                        count++;
                    }
                     if(hset.contains(str4))
                    {
                        count++;
                    }
                    result[count]++;
                    a++;
                    h.add(s);
                 }
            }
           // x,y at 3rd position
           if(x-1>=0 && y+1<n)
           {
                 String str2=Integer.toString(x-1)+" "+Integer.toString(y);
                 String str3=Integer.toString(x-1)+" "+Integer.toString(y+1);
                 String str4=Integer.toString(x)+" "+Integer.toString(y+1);
                 String s=str2+"|"+str3+"|"+str1+"|"+str4;
                 if(!h.contains(s))
                 {
                    int count=1;
                    if(hset.contains(str2))
                    {
                        count++;
                    }
                    if(hset.contains(str3))
                    {
                        count++;
                    }
                     if(hset.contains(str4))
                    {
                        count++;
                    }
                    result[count]++;
                    a++;
                    h.add(s);
                 }
           }
           // x,y at 4th position
           if(y-1>=0 && x-1>=0)
           {
                 String str2=Integer.toString(x-1)+" "+Integer.toString(y-1);
                 String str3=Integer.toString(x-1)+" "+Integer.toString(y);
                 String str4=Integer.toString(x)+" "+Integer.toString(y-1);
                 String s=str2+"|"+str3+"|"+str4+"|"+str1;
                 if(!h.contains(s))
                 {
                    int count=1;
                    if(hset.contains(str2))
                    {
                        count++;
                    }
                    if(hset.contains(str3))
                    {
                        count++;
                    }
                     if(hset.contains(str4))
                    {
                        count++;
                    }
                    result[count]++;
                    a++;
                    h.add(s);
                 }
           }     
        }

        result[0]=total-a;

        return result;
    }
}
