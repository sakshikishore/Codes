class Solution {
    public int numTilePossibilities(String tiles) {
        int count=0;
       String arr[]=new String[tiles.length()];
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<tiles.length();i++)
        {
            arr[i]=tiles.substring(i,i+1);
        }
        for(int i=0;i<(1<<tiles.length());i++)
        {
            String str="";
            for(int j=0;j<tiles.length();j++)
            {
                if((i & (1<<j))>0)
                {
                    str=str+arr[j];
                }
            }
           if(str.length()>0)
            {
               char c[]=str.toCharArray();
               Arrays.sort(c);
               String pr=new String(c);
                if(!list.contains(pr))
                {          
                   list.add(pr);
                    if(str.length()==1)
                    {
                        count++;
                    }
                    else 
                    {
                        int l=1;
                        int m=1;
                        int ch[]=new int[26];
                        for(int k=0;k<str.length();k++)
                        {
                            ch[str.charAt(k)-'A']++;
                        }
                        for(int k=0;k<26;k++)
                        {
                            if(ch[k]>1)
                            {
                                for(int p=1;p<=ch[k];p++)
                                {
                                    l=l*p;
                                }
                            }
                        }
                        for(int p=1;p<=str.length();p++)
                        {
                           m=m*p; 
                        }
                        count=count+(m/l);
                    }
                }
            }
        }
       
        return count;
        
    }
}
