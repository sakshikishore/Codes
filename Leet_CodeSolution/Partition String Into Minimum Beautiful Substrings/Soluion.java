class Solution {
    public int minimumBeautifulSubstrings(String s) {
        if(s.charAt(0)=='0')
        {
            return -1;
        }
        List<List<Integer>> list=new ArrayList();
        int min=16;
        for(int i=0;i<s.length();i++)
        {
           ArrayList<Integer> l=new ArrayList<Integer>();
           String str=s.substring(0,i+1);
           int x=Integer.parseInt(str,2);
           int p=(int)(Math.log(x)/Math.log(5));
           int r=(int)Math.pow(5,p);
           if(r==x)
           {
               l.add(1);
               if(i==s.length()-1)
               {
                   return 1;
               }
           }
           for(int j=i-1;j>=0;j--)
           {
                str=s.substring(j+1,i+1);
                if(str.charAt(0)!='0')
                {
                       x=Integer.parseInt(str,2);
                       p=(int)(Math.log(x)/Math.log(5));
                       r=(int)Math.pow(5,p);
                       if(r==x)
                       {
                            for(int k=0;k<list.get(j).size();k++)
                            {
                                int val=list.get(j).get(k);
                                l.add(val+1);
                                if(i==s.length()-1)
                                {
                                    if(val+1<min)
                                    {
                                        min=val+1;
                                    }
                                }
                            }
                       }
                }
           }
          list.add(l);
            
        }
        if(min==16)
        {
            return -1;
        }
        
        return min;
    }
}
